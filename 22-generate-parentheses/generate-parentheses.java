class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(result, n, n, sb);
        return result;
    }
    private void backTrack(List<String> result, int leftB, int rightB, StringBuilder sb) {
        if (leftB == 0 && rightB == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftB > 0) {
            sb.append('(');
            backTrack(result, leftB - 1, rightB, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightB > leftB) {
            sb.append(')');
            backTrack(result, leftB, rightB - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}