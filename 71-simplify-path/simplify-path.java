class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else if (!s.equals(".") && !s.equals("..") && !s.isEmpty()) {
                stack.push(s);
            }
        } 
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}