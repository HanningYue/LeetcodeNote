class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n, n, "", result);
        return result;
    }
    private void backTrack(int leftBracket, int rightBracket, String currentPath, List<String> result) {
        if (leftBracket == 0 && rightBracket == 0) {
            result.add(currentPath);
            return;
        }
        if (leftBracket > 0) {
            backTrack(leftBracket - 1, rightBracket, currentPath + "(", result);
        }
        if (rightBracket > leftBracket) {
            backTrack(leftBracket, rightBracket - 1, currentPath + ")", result);
        }
    }
}