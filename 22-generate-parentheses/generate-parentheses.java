class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(n, n, result, sb);
        return result;
    }
    private void backTrack(int leftBracket, int rightBracket, List<String> result, StringBuilder sb) {
        if (leftBracket == 0 && rightBracket == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftBracket > 0) {
            sb.append('(');
            backTrack(leftBracket - 1, rightBracket, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBracket > leftBracket) {
            sb.append(')');
            backTrack(leftBracket, rightBracket - 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}