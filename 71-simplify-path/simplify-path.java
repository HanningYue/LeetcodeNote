class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (!s.isEmpty() && !s.equals("..") && !s.equals(".")) {
                stack.push(s);
            }
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
        }
        
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}