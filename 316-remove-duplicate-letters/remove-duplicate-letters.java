class Solution {
    public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0) {
                    char lastChar = stack.pop();
                    set.remove(lastChar);
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