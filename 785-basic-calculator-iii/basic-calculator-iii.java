class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        return recursion(queue);
    }
    private int recursion(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        int sign = '+';
        int sum = 0;

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (Character.isDigit(current)) {
                sum = sum * 10 + current - '0';
            }
            if (current == '(') {
                sum = recursion(queue);
            }

            if (!Character.isDigit(current) || queue.isEmpty()) {
                if (sign == '+') {
                    stack.push(sum);
                } else if (sign == '-') {
                    stack.push(-sum);
                } else if (sign == '*') {
                    stack.push(stack.pop() * sum);
                } else if (sign == '/') {
                    stack.push(stack.pop() / sum);
                }
                sign = current;
                sum = 0;
            }

            if (current == ')') {
                break;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}