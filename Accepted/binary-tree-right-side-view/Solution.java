class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue <TreeNode> q=new ArrayDeque<>();
        if(root==null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int count = q.size();
            while(count!=0)
            {
                TreeNode curr=q.poll();
                temp.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                count--;
            }
            res.add(temp.getLast());
        }
        return res;
    }
}