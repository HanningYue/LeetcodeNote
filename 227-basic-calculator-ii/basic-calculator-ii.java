class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }   
        
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int sum = 0;
        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (Character.isDigit(current)) {
                sum = sum * 10 + (current - '0');
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
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}