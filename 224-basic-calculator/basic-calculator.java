class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        return dfs(queue);
    }
    private int dfs(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (Character.isDigit(current)) {
                num = num * 10 + (current - '0');
            }

            if (current == '(') {
                num = dfs(queue);
            }

            if (!Character.isDigit(current) || queue.isEmpty()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                }
                sign = current;
                num = 0;
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