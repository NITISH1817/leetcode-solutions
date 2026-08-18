class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> st=new ArrayDeque<>();
        if(root==null) return res;
        boolean flag=true;
        st.offer(root);
        while(!st.isEmpty()){
            List <Integer> temp=new ArrayList();
            int count=st.size();
            while(count!=0){
                TreeNode curr=st.poll();
                temp.add(curr.val);
                if(curr.left!=null)st.offer(curr.left);
                if(curr.right!=null)st.offer(curr.right);
                count--;
            }
            if(flag==false)
            Collections.reverse(temp);
            res.add(temp);
            flag=!flag;
        }
        return res;
    }
}