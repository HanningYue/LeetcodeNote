class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0) {
                    set.remove(stack.pop());
                }
                stack.push(c);
                set.add(c);
            }
            map.put(c, map.get(c) - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}