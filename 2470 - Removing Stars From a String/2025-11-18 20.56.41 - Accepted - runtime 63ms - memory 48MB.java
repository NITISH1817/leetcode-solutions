class Solution {
    public String removeStars(String s) {
        StringBuilder str=new StringBuilder();
        Stack <Character> st=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c=='*')
            {
                st.pop();
            }
            else
            {
                st.push(c);
            }
        }
        for(char c:st)
        {
            str.append(c);
        }
        return str.toString();
    }
}