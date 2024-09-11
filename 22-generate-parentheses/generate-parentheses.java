class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTracking(result, n, n, "");
        return result;
    }
    private void backTracking(List<String> result, int rightBracket, int leftBracket, String s) {
        if (rightBracket == 0 && leftBracket == 0) {
            result.add(s);
            return;
        }
        if (leftBracket > 0) {
            backTracking(result, rightBracket, leftBracket - 1, s + "(");
        }
        if (leftBracket < rightBracket) {
            backTracking(result, rightBracket - 1, leftBracket, s + ")");
        }
    }
}