class Solution {
    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] count = new int[n];

        int i = 0; // write pointer

        for (int j = 0; j < n; j++) { // read pointer
            arr[i] = arr[j];

            if (i > 0 && arr[i] == arr[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }

            // if count reaches k → remove block
            if (count[i] == k) {
                i -= k; // delete last k characters
            }

            i++;
        }

        return new String(arr, 0, i);
    }
}
