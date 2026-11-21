
class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;

        for (int num : nums) {
            int count = 2;
            int sum = num + 1;

            for (int i = 2; i <= num / i; i++) {
                if (num % i == 0) {
                    count++;
                    sum += i;

                    if (i != num / i) {
                        count++;
                        sum += num / i;
                    }

                    if (count > 4) {
                        break;
                    }
                }
            }

            if (count == 4) {
                total += sum;
            }
        }

        return total;
    }
}
