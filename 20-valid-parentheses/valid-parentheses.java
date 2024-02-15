class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == leftOf(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }   
        return stack.isEmpty();
    }
    private char leftOf(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        }
        return '{';
    }
}