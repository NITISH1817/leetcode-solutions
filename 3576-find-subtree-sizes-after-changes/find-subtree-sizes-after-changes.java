import java.util.*;
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
        int[] newParent = new int[n];
        int[] last = new int[26];
        int[] previous = new int[n];
        Arrays.fill(last, -1);
        newParent[0] = -1;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int node = curr[0];
            int state = curr[1];
            int c = s.charAt(node) - 'a';
            if (state == 0) {
                previous[node] = last[c];
                if (node != 0) {
                    newParent[node] = last[c] == -1
                            ? parent[node]
                            : last[c];
                }
                last[c] = node;
                stack.push(new int[]{node, 1});
                for (int child : children.get(node)) {
                    stack.push(new int[]{child, 0});
                }
            } else {
                last[c] = previous[node];
            }
        }
        List<List<Integer>> modified = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            modified.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            modified.get(newParent[i]).add(i);
        }
        List<Integer> order = new ArrayList<>();
        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) {
            int node = stack.pop()[0];
            order.add(node);
            for (int child : modified.get(node)) {
                stack.push(new int[]{child, 0});
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = order.size() - 1; i >= 0; i--) {
            int node = order.get(i);
            if (newParent[node] != -1) {
                ans[newParent[node]] += ans[node];
            }
        }
        return ans;
    }
}