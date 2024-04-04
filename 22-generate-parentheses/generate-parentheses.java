class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(result, n, n, sb);
        return result;
    }
    private void backTrack(List<String> result, int leftBracket, int rightBracket, StringBuilder sb) {
        if (leftBracket == 0 && rightBracket == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftBracket > 0) {
            sb.append("(");
            backTrack(result, leftBracket - 1, rightBracket, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBracket > leftBracket) {
            sb.append(")");
            backTrack(result, leftBracket, rightBracket - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}