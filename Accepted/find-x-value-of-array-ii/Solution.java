class Solution {
    int n, k;
    Node[] st;

    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
            prod = 1 % k;
        }
    }

    Node merge(Node a, Node b) {
        Node c = new Node(k);
        c.prod = (a.prod * b.prod) % k;

        for (int i = 0; i < k; i++) {
            c.cnt[i] += a.cnt[i];
            c.cnt[(a.prod * i) % k] += b.cnt[i];
        }

        return c;
    }

    void build(int p, int l, int r, int[] nums) {
        if (l == r) {
            st[p] = new Node(k);
            st[p].prod = nums[l] % k;
            st[p].cnt[st[p].prod] = 1;
            return;
        }

        int m = (l + r) / 2;

        build(p * 2, l, m, nums);
        build(p * 2 + 1, m + 1, r, nums);

        st[p] = merge(st[p * 2], st[p * 2 + 1]);
    }

    void update(int p, int l, int r, int idx, int val) {
        if (l == r) {
            st[p] = new Node(k);
            st[p].prod = val % k;
            st[p].cnt[st[p].prod] = 1;
            return;
        }

        int m = (l + r) / 2;

        if (idx <= m)
            update(p * 2, l, m, idx, val);
        else
            update(p * 2 + 1, m + 1, r, idx, val);

        st[p] = merge(st[p * 2], st[p * 2 + 1]);
    }

    Node query(int p, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr)
            return st[p];

        int m = (l + r) / 2;

        if (qr <= m)
            return query(p * 2, l, m, ql, qr);

        if (ql > m)
            return query(p * 2 + 1, m + 1, r, ql, qr);

        return merge(
            query(p * 2, l, m, ql, qr),
            query(p * 2 + 1, m + 1, r, ql, qr)
        );
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        n = nums.length;
        this.k = k;

        st = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            ans[i] = query(1, 0, n - 1, start, n - 1).cnt[x];
        }

        return ans;
    }
}