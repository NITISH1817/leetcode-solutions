import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] positions = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            positions[s.charAt(i) - 'a'].add(i);
        }

        int count = 0;

        for (String word : words) {
            int prev = -1;
            boolean found = true;

            for (char c : word.toCharArray()) {
                List<Integer> list = positions[c - 'a'];

                int index = Collections.binarySearch(list, prev + 1);

                if (index < 0) {
                    index = -index - 1;
                }

                if (index == list.size()) {
                    found = false;
                    break;
                }

                prev = list.get(index);
            }

            if (found) {
                count++;
            }
        }

        return count;
    }
}