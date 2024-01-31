class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                while (!stack.isEmpty() && map.get(stack.peek()) > 0 && stack.peek() > c) {
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);
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