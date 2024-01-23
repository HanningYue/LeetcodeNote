class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()[0]) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }
            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : stack) {
            sb.append(String.valueOf((char)arr[0]).repeat(arr[1]));
        }
        return sb.toString();
    }
}