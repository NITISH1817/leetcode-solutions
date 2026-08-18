class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            int totalWeight = 0;
            for (char ch : word.toCharArray()) {
                totalWeight += weights[ch - 'a'];
            }
            char mappedChar = (char) ('z' - (totalWeight % 26));
            result.append(mappedChar);}
        return result.toString();
    }
}