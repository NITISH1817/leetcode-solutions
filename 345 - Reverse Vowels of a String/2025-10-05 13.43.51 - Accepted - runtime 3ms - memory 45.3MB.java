class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        // define vowels
        String vowels = "aeiouAEIOU";

        while (left < right) {
            // move left pointer to the next vowel
            while (left < right && vowels.indexOf(arr[left]) == -1) {
                left++;
            }
            // move right pointer to the previous vowel
            while (left < right && vowels.indexOf(arr[right]) == -1) {
                right--;
            }

            // swap vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}
