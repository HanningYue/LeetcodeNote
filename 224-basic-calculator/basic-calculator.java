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
        int previousSum = 0;
        char previousSign = '+';
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (Character.isDigit(current)) {
                previousSum = previousSum * 10 + current - '0';
            }
            if (current == '(') {
                previousSum = recursion(queue);
            }
            if (!Character.isDigit(current) || queue.isEmpty()) {
                if (previousSign == '+') {
                    stack.push(previousSum);
                } else if (previousSign == '-') {
                    stack.push(-previousSum);
                }
                previousSign = current;
                previousSum = 0;
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