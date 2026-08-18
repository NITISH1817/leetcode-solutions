class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {

            int parentVal = d[0];
            int childVal = d[1];
            int isLeft = d[2];

            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);

            if (isLeft == 1)
                parent.left = child;
            else
                parent.right = child;

            children.add(childVal);
        }

        for (int[] d : descriptions) {
            int parentVal = d[0];

            if (!children.contains(parentVal))
                return map.get(parentVal);
        }

        return null;
    }
}