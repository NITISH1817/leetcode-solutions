class Solution {

    private void iot(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        iot(root.left, res);
        res.add(root.val);
        iot(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        iot(root, res);
        return res;
    }
}
