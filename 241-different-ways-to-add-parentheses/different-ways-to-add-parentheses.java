class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') {
                            result.add(a + b);
                        } else if (c == '-') {
                            result.add(a - b);
                        } else if (c == '*') {
                            result.add(a * b);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}