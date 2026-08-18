class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder str =new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                st.pop();
            }
            else
            {
                st.push(ch);
            }
        }
        for(char c:st)
        {
            str.append(c);
        }
        return str.toString();
    }
}