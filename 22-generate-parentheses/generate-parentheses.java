class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }
    private void dfs(List<String> result, int rightBracket, int leftBracket, String s) {
        if (rightBracket == 0 && leftBracket == 0) {
            result.add(s);
            return;
        }
        if (leftBracket > 0) {
            dfs(result, rightBracket, leftBracket - 1, s + "(");
        }
        if (leftBracket < rightBracket) {
            dfs(result, rightBracket - 1, leftBracket, s + ")");
        }
    }
}