class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != leftBracket(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private char leftBracket(char c) {
        if (c == '}') {
            return '{';
        } else if (c == ')') {
            return '(';
        }
        return '[';
    }
}