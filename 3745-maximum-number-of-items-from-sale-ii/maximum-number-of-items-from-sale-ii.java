
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        
        int[] gain = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--;
        }

        // Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long ans = 0;
        long money = budget;

        // Buy items that give one free item
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price >= 2L * minPrice) {
                break;
            }

            long buy = Math.min(gain[factor], money / price);

            ans += buy * 2;
            money -= buy * price;
        }

        // Spend remaining money on the cheapest item
        ans += money / minPrice;

        return (int) ans;
    }
}
