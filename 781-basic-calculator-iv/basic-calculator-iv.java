import java.util.*;

class Solution {
    // Helper class to represent a polynomial
    static class Poly {
        // Maps a list of variable names (sorted lexicographically) to its coefficient.
        // An empty list key represents the constant term.
        Map<List<String>, Integer> count = new HashMap<>();

        Poly() {}

        Poly(String var, int val) {
            List<String> key = new ArrayList<>();
            if (!var.isEmpty()) {
                key.add(var);
            }
            count.put(key, val);
        }

        Poly add(Poly that) {
            Poly ans = new Poly();
            for (List<String> k : this.count.keySet()) {
                ans.count.put(k, ans.count.getOrDefault(k, 0) + this.count.get(k));
            }
            for (List<String> k : that.count.keySet()) {
                ans.count.put(k, ans.count.getOrDefault(k, 0) + that.count.get(k));
            }
            return ans;
        }

        Poly sub(Poly that) {
            Poly ans = new Poly();
            for (List<String> k : this.count.keySet()) {
                ans.count.put(k, ans.count.getOrDefault(k, 0) + this.count.get(k));
            }
            for (List<String> k : that.count.keySet()) {
                ans.count.put(k, ans.count.getOrDefault(k, 0) - that.count.get(k));
            }
            return ans;
        }

        Poly mul(Poly that) {
            Poly ans = new Poly();
            for (List<String> k1 : this.count.keySet()) {
                for (List<String> k2 : that.count.keySet()) {
                    List<String> k3 = new ArrayList<>();
                    k3.addAll(k1);
                    k3.addAll(k2);
                    Collections.sort(k3);
                    int coeff = this.count.get(k1) * that.count.get(k2);
                    ans.count.put(k3, ans.count.getOrDefault(k3, 0) + coeff);
                }
            }
            return ans;
        }

        Poly evaluate(Map<String, Integer> evalMap) {
            Poly ans = new Poly();
            for (List<String> k : this.count.keySet()) {
                int c = this.count.get(k);
                List<String> freeVars = new ArrayList<>();
                for (String var : k) {
                    if (evalMap.containsKey(var)) {
                        c *= evalMap.get(var);
                    } else {
                        freeVars.add(var);
                    }
                }
                ans.count.put(freeVars, ans.count.getOrDefault(freeVars, 0) + c);
            }
            return ans;
        }

        List<String> toList() {
            List<List<String>> keys = new ArrayList<>();
            for (List<String> k : count.keySet()) {
                if (count.get(k) != 0) {
                    keys.add(k);
                }
            }

            // Sort by degree descending, then lexicographically
            Collections.sort(keys, (a, b) -> {
                if (a.size() != b.size()) {
                    return b.size() - a.size();
                }
                for (int i = 0; i < a.size(); i++) {
                    int cmp = a.get(i).compareTo(b.get(i));
                    if (cmp != 0) return cmp;
                }
                return 0;
            });

            List<String> res = new ArrayList<>();
            for (List<String> k : keys) {
                int coeff = count.get(k);
                StringBuilder sb = new StringBuilder();
                sb.append(coeff);
                for (String var : k) {
                    sb.append("*").append(var);
                }
                res.add(sb.toString());
            }
            return res;
        }
    }

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> evalMap = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            evalMap.put(evalvars[i], evalints[i]);
        }

        Poly result = parse(expression).evaluate(evalMap);
        return result.toList();
    }

    private Poly parse(String expr) {
        List<Object> tokens = parseToTokens(expr);
        return evaluateTokens(tokens);
    }

    private List<Object> parseToTokens(String s) {
        List<Object> tokens = new ArrayList<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '(' || c == ')' || c == '+' || c == '-' || c == '*') {
                tokens.add(c);
                i++;
            } else if (Character.isDigit(c)) {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                tokens.add(new Poly("", val));
            } else if (Character.isLowerCase(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isLowerCase(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                tokens.add(new Poly(sb.toString(), 1));
            }
        }
        return tokens;
    }

    private Poly evaluateTokens(List<Object> tokens) {
        Stack<Poly> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int i = 0;
        while (i < tokens.size()) {
            Object token = tokens.get(i);
            if (token instanceof Poly) {
                operandStack.push((Poly) token);
            } else if ((Character) token == '(') {
                operatorStack.push('(');
            } else if ((Character) token == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    popAndApply(operandStack, operatorStack.pop());
                }
                operatorStack.pop(); // Pop '('
            } else if ((Character) token == '+' || (Character) token == '-' || (Character) token == '*') {
                char op = (Character) token;
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(op)) {
                    popAndApply(operandStack, operatorStack.pop());
                }
                operatorStack.push(op);
            }
            i++;
        }

        while (!operatorStack.isEmpty()) {
            popAndApply(operandStack, operatorStack.pop());
        }

        return operandStack.pop();
    }

    private int precedence(char op) {
        if (op == '*') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    private void popAndApply(Stack<Poly> operands, char op) {
        Poly right = operands.pop();
        Poly left = operands.pop();
        if (op == '+') operands.push(left.add(right));
        else if (op == '-') operands.push(left.sub(right));
        else if (op == '*') operands.push(left.mul(right));
    }
}