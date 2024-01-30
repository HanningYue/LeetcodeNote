class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(result, sb, n, n);
        return result;
    }
    private void backTrack(List<String> result, StringBuilder sb, int leftBracket, int rightBracket) {
        if (leftBracket == 0 && rightBracket == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftBracket > 0) {
            sb.append('(');
            backTrack(result, sb, leftBracket - 1, rightBracket);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBracket > leftBracket) {
            sb.append(')');
            backTrack(result, sb, leftBracket, rightBracket - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}