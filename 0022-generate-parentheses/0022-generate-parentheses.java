/*
Using a DFS to solve the problem
We are given n-pairs of '(' and ')'. To find all the combination, we can use DFS n times
1. WE NEED TO MAKE SURE LEFTBRACKET ) IS ALWAYS GREATER THAN THE LEFTBRACKET (
2. So, when rightBracket is not zero and greater than leftBracket, minus the number of rightBracket by 1, add ')' to the path
3. Same for leftBracket but only need leftBracket to be greater than 0
4. When both n pairs of leftBracket and rightBracket reach 0, add new String to result, return result.
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, result, "");
        return result;
    }
    private void dfs(int leftBracket, int rightBracket, List<String> result, String path) {
        if (leftBracket == 0 && rightBracket == 0) {
            result.add(new String(path));
            return;
        }
        if (rightBracket > 0 && rightBracket > leftBracket) {
            dfs(leftBracket, rightBracket - 1, result, path + ')');
        }
        if (leftBracket > 0) {
            dfs(leftBracket - 1, rightBracket, result, path + '(');
        }
    }
}