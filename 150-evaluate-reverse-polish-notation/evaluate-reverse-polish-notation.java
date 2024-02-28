class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int one = Integer.parseInt(stack.pop());
                int two = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(one + two));
            } else if (token.equals("-")) {
                int one = Integer.parseInt(stack.pop());
                int two = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(two - one));
            } else if (token.equals("/")) {
                int one = Integer.parseInt(stack.pop());
                int two = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(two / one));
            } else if (token.equals("*")) {
                int one = Integer.parseInt(stack.pop());
                int two = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(one * two));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}