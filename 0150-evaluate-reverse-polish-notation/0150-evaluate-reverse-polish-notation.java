/*

*/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int former = 0, latter = 0;
        
        for (String token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    latter = stack.pop();
                    former = stack.pop();
                    stack.push(former - latter);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    latter = stack.pop();
                    former = stack.pop();
                    stack.push(former / latter);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}