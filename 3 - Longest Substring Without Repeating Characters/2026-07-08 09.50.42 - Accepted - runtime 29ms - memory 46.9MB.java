class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxx=0,curr=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            curr=0;
            int [] visited =new int[256];
            Arrays.fill(visited,-1);
            for(int j=i;j<n;j++)
            {
                if(visited[s.charAt(j)]!=-1)
                    break;
                curr++;
                maxx=Math.max(maxx,curr);
                visited[s.charAt(j)]=j;
            }
        }
        return maxx;
    }
}