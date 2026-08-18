class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue <TreeNode> q = new ArrayDeque();
        q.offer(root);
        int level=0;
        while(!q.isEmpty())
        {
            int count=q.size();
            while(count-- != 0)
            {
                TreeNode curr=q.poll();
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
                if(curr.left==null && curr.right==null) return level+1;
            }
            level++;
        }
         return 0;
    }
}