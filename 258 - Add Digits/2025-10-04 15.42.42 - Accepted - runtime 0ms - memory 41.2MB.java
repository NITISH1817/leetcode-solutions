class Solution {
    public int addDigits(int num) {
        while (num >= 10) {  // Loop until it's a single-digit number
            int sum = 0;
            while (num != 0) {
                sum += num % 10; // Add last digit
                num /= 10;       // Remove last digit
            }
            num = sum; // Replace num with sum of digits
        }
        return num;
    }
}
