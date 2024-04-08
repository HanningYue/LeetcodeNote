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
    private char leftOf(char rightBracket) {
        if (rightBracket == ')') {
            return '(';
        } else if (rightBracket == ']') {
            return '[';
        }
        return '{';
    }
}

/*
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>(); //{left, right};
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek().equals(map.get(c))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
*/