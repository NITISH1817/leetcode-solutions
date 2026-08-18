/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue <TreeNode> q=new ArrayDeque<>();
        if(root==null) return res;
        q.offer(root);
        while(!q.isEmpty())
        {
            List<Integer> temp=new ArrayList();  
            int count=q.size();
            while(count!=0)
            {
                TreeNode curr=q.poll();
                temp.add(curr.val);
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
                count--;
            }
            res.add(temp);
        }
        return res;
    }
}