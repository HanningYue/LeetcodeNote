class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c :s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > 0) {
                    set.remove(stack.peek());
                    stack.pop();
                }
                set.add(c);
                stack.push(c);
            }
            map.put(c, map.get(c) - 1);
        }
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}