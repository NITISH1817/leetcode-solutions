class Solution {
    public boolean checkOverlap(int r, int x, int y,
                                int x1, int y1, int x2, int y2) {
        int cx = Math.max(x1, Math.min(x, x2));
        int cy = Math.max(y1, Math.min(y, y2));
        int dx = x - cx;
        int dy = y - cy;
        return dx * dx + dy * dy <= r * r;
    }
}