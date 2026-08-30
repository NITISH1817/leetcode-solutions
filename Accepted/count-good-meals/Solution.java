import java.util.*;
class Solution {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long count = 0;
        int MOD = 1000000007;
        for (int num : deliciousness) {
            for (int power = 1; power <= 2097152; power *= 2) {
                int need = power - num;
                count += map.getOrDefault(need, 0);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int)(count % MOD);
    }
}