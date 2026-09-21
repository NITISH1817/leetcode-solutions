class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sen = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sen.append(Character.toLowerCase(ch));
            }
        }

        return sen.toString().equals(sen.reverse().toString());
    }
}