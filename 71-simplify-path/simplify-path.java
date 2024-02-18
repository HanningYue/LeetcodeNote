class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : strs) {
            if (!s.isEmpty() && !s.equals(".") && !s.equals("..")) {
                stack.push(s);
            } else if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}