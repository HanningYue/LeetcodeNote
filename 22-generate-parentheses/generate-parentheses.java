class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, n, n, "");
        return result;
    }
    private void backTrack(List<String> result, int leftBracket, int rightBracket, String str) {
        if (leftBracket == 0 && rightBracket == 0) {
            result.add(new String(str));
            return;
        }
        if (leftBracket > 0) {
            backTrack(result, leftBracket - 1, rightBracket, str + "(");
        }
        if (rightBracket > leftBracket) {
            backTrack(result, leftBracket, rightBracket - 1, str + ")");
        }
    }
}