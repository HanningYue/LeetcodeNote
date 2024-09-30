class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else if (!s.isEmpty() && !s.equals("..") && !s.equals(".")) {
                stack.push(s);
            }
        }
        
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}