class Solution {
    int res = 0;

    private void sum(TreeNode root, int rs) {
        if (root == null)
            return;

        // If it is a leaf node
        if (root.left == null && root.right == null) {
            res = res + rs * 10 + root.val;
            return;
        }

        // Update the current number
        int curr = rs * 10 + root.val;

        sum(root.left, curr);
        sum(root.right, curr);
    }

    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return res;
    }
}