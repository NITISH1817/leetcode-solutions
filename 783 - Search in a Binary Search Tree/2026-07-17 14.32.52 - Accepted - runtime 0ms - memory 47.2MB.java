class Solution {
    TreeNode find(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key)
            return root;

        TreeNode left = find(root.left, key);
        if (left != null)
            return left;

        return find(root.right, key);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return find(root, val);
    }
}