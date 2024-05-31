class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        char previousSign = '+';
        int sum = 0;
        int lastIndexOfNumber = s.length() - 1;
        while (lastIndexOfNumber >= 0 && s.charAt(lastIndexOfNumber) == ' ') {
                lastIndexOfNumber--;
            if (lastIndexOfNumber == -1) {
                return 0;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                sum = sum * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == lastIndexOfNumber) {
                if (previousSign == '+') {
                    stack.push(sum);
                } else if (previousSign == '-') {
                    stack.push(-sum);
                } else if (previousSign == '*') {
                    stack.push(stack.pop() * sum);
                } else if (previousSign == '/') {
                    stack.push(stack.pop() / sum);
                }
                previousSign = c;
                sum = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}