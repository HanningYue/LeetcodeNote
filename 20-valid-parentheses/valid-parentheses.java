class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                if (stack.peek() == match(c)) {
                    stack.pop();
                } else if (stack.peek() != match(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char match(char c) {
        if (c == ']') {
            return '[';
        } else if (c == '}') {
            return '{';
        }
        return '(';
    }
}