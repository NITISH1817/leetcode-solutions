class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;                 // to build the number from string
        char sign = '+';             // previous operator

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build number (convert char → int)
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');  // string → integer logic
            }

            // If operator OR end of string → apply previous sign
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = ch;   // update operator
                num = 0;     // reset number
            }
        }

        // Sum all values in stack
        int result = 0;
        for (int x : stack) result += x;

        return result;
    }
}
