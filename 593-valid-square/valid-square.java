import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        
        set.add(distSq(p1, p2));
        set.add(distSq(p1, p3));
        set.add(distSq(p1, p4));
        set.add(distSq(p2, p3));
        set.add(distSq(p2, p4));
        set.add(distSq(p3, p4));
        
        return !set.contains(0) && set.size() == 2;
    }
    
    private int distSq(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}