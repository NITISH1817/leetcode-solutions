class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int missing = 3;

        boolean lower = false, upper = false, digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            if (Character.isUpperCase(c)) upper = true;
            if (Character.isDigit(c)) digit = true;
        }

        missing -= (lower ? 1 : 0) + (upper ? 1 : 0) + (digit ? 1 : 0);

        int replace = 0, one = 0, two = 0;

        for (int i = 0; i < n;) {
            int j = i;

            while (j < n && password.charAt(j) == password.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (len >=3 ) {
                replace += len / 3;

                if (len % 3 == 0) one++;
                else if (len % 3 == 1) two++;
            }

            i = j;
        }

        if (n < 6) {
            return Math.max(6 - n, missing);
        }

        if (n <= 20) {
            return Math.max(missing, replace);
        }

        int delete = n - 20;

        int use = Math.min(one, delete);
        replace -= use;
        delete -= use;

        use = Math.min(two, delete / 2);
        replace -= use;
        delete -= use * 2;

        use = Math.min(replace, delete / 3);
        replace -= use;

        return (n - 20) + Math.max(missing, replace);
    }
}