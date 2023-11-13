/*
For stack, we push the corresponding left-open bracket for each case of right open bracket, if the next character is not equals to just added character to stack. Then the next character is not the correct left-open bracket. Return false. 
When stack is empty, return true;
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}