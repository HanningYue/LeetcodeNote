class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(result, n, n, sb);
        return result;
    }
    private void backTrack(List<String> result, int leftBracketLeft, int rightBracketLeft, StringBuilder sb) {
        if (leftBracketLeft == 0 && rightBracketLeft == 0) {
            result.add(sb.toString());
            return;
        }

        if (leftBracketLeft > 0) {
            sb.append('(');
            backTrack(result, leftBracketLeft - 1, rightBracketLeft, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBracketLeft > leftBracketLeft) {
            sb.append(')');
            backTrack(result, leftBracketLeft, rightBracketLeft - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}