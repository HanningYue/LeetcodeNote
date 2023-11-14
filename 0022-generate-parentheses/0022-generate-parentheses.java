/*
Using a DFS to solve the problem, 
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, "", result);
        return result;
    }
    private void dfs(int leftBracket, int rightBracket, String path, List<String> result) {
        if (leftBracket == 0 && rightBracket == 0) {
            result.add(new String(path));
            return;
        }
        if (rightBracket > 0 && leftBracket < rightBracket) {
            dfs(leftBracket, rightBracket - 1, path + ')', result);
        }
        if (leftBracket > 0) {
            dfs(leftBracket - 1, rightBracket, path + '(', result);
        }
    }
}