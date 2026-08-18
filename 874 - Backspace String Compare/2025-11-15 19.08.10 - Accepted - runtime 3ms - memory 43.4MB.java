import java.util.Stack;
class Solution {
    public boolean backspaceCompare(String s, String t) {

        // Process first string s
        char[] ch = s.toCharArray();
        Stack<Character> ak = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == '#') {
                if (!ak.isEmpty()) ak.pop();   // FIXED
            } else {
                ak.push(ch[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ak) {
            sb.append(c);
        }

        // Process second string t
        char[] ch1 = t.toCharArray();
        Stack<Character> ka = new Stack<>();
        for (int i = 0; i < t.length(); i++) {
            if (ch1[i] == '#') {
                if (!ka.isEmpty()) ka.pop();  // FIXED HERE
            } else {
                ka.push(ch1[i]);
            }
        }

        StringBuilder sb1 = new StringBuilder();
        for (char c : ka) {
            sb1.append(c);
        }

        return sb1.toString().equals(sb.toString());
    }
}
