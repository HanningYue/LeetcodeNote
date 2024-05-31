class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        return recursion(queue);
    }
    private int recursion(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        char previousSign = '+';

        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                sum = sum * 10 + c - '0';
            }
            if (c == '(') {
                sum = recursion(queue);
            }
            if (!Character.isDigit(c) || queue.isEmpty()) {
                if (previousSign == '+') {
                    stack.push(sum);
                } else if (previousSign == '-') {
                    stack.push(-sum);
                }
                previousSign = c;
                sum = 0;
            }
            if (c == ')') {
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