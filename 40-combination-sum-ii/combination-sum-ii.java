import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int[] a, int target, int start,
                    List<Integer> current,
                    List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < a.length; i++) {

            if (i > start && a[i] == a[i - 1])
                continue;

            if (a[i] > target)
                break;

            current.add(a[i]);

            backtrack(a, target - a[i], i + 1, current, ans);

            current.remove(current.size() - 1);
        }
    }
}