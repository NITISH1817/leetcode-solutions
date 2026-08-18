class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p == null || q == null ? p == q 
             : p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
