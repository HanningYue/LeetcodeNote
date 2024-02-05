class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, result, sb);
        return result;
    }
    private void dfs(int leftB, int rightB, List<String> result, StringBuilder sb) {
        if (leftB == 0 && rightB == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftB > 0) {
            sb.append('(');
            dfs(leftB - 1, rightB, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightB > leftB) {
            sb.append(')');
            dfs(leftB, rightB - 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}