import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[][] up;
    int[] depth, tin, tout, prefix;
    int timer;
    Fenwick bit;
    char[] chars;
    int LOG;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        chars = s.toCharArray();
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        prefix = new int[n];

        buildTree(n);

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        bit = new Fenwick(n);
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = mask(chars[u]) ^ mask(c);

                if (delta != 0) {
                    bit.rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int lca = getLCA(u, v);

                int pu = prefix[u] ^ bit.pointQuery(tin[u]);
                int pv = prefix[v] ^ bit.pointQuery(tin[v]);

                int pathMask = pu ^ pv ^ mask(chars[lca]);

                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    void buildTree(int n) {
        int[] stackNode = new int[n];
        int[] stackParent = new int[n];
        int[] stackIndex = new int[n];

        int top = 0;
        int timer = 0;

        stackNode[0] = 0;
        stackParent[0] = 0;
        stackIndex[0] = 0;

        tin[0] = timer++;
        prefix[0] = mask(chars[0]);
        up[0][0] = 0;

        while (top >= 0) {
            int u = stackNode[top];

            if (stackIndex[top] < graph[u].size()) {
                int v = graph[u].get(stackIndex[top]++);

                if (v == stackParent[top]) continue;

                depth[v] = depth[u] + 1;
                up[0][v] = u;
                prefix[v] = prefix[u] ^ mask(chars[v]);
                tin[v] = timer++;

                top++;
                stackNode[top] = v;
                stackParent[top] = u;
                stackIndex[top] = 0;
            } else {
                tout[u] = timer - 1;
                top--;
            }
        }
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if (((diff >> j) & 1) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    int mask(char c) {
        return 1 << (c - 'a');
    }

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void add(int i, int value) {
            for (; i <= n + 1; i += i & -i) {
                tree[i] ^= value;
            }
        }

        void rangeXor(int l, int r, int value) {
            add(l + 1, value);
            add(r + 2, value);
        }

        int pointQuery(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}