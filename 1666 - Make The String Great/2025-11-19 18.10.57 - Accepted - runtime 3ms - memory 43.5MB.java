class Solution {
    public String makeGood(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && Math.abs(st.peek() - ch) == 32) {
                st.pop();    // remove the bad pair
            } else {
                st.push(ch); // add character
            }
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
}
