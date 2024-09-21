class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visited = new HashSet<>();
        
        int slow = 0, length = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            char fastChar = s.charAt(fast);
            while (!visited.add(fastChar)) {
                char slowChar = s.charAt(slow);
                visited.remove(slowChar);
                slow++;
            }
            length = Math.max(length, visited.size());
        }
        return length;
    }
}