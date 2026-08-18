import java.util.*;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {

        Map<Double, Integer> map = new HashMap<>();
        long count = 0;

        for (int[] rectangle : rectangles) {

            double ratio = (double) rectangle[0] / rectangle[1];

            count += map.getOrDefault(ratio, 0);

            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }

        return count;
    }
}