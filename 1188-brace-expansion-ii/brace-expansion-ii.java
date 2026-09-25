class Solution {
    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    Set<String> solve(String s) {
        Set<String> res = new HashSet<>();
        res.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            if (s.charAt(i) == ',') {
                i++;
                res.addAll(solve(s));
            } 
            else {
                Set<String> next = new HashSet<>();

                if (s.charAt(i) == '{') {
                    i++;
                    next = solve(s);
                    i++;
                } 
                else {
                    next.add("" + s.charAt(i++));
                }

                Set<String> temp = new HashSet<>();

                for (String a : res)
                    for (String b : next)
                        temp.add(a + b);

                res = temp;
            }
        }

        return res;
    }
}