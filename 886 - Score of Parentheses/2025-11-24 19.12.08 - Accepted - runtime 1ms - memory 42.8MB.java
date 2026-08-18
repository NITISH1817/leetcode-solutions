class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);       
            } else {
                int v = st.pop(); 
                int add = (v == 0) ? 1 : 2 * v; 
                st.push(st.pop() + add); 
            }
        }
        return st.pop();
    }
}
