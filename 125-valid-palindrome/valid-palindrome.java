public class Solution {
    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Create a deque (double-ended queue) from the string
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }

        // Continue until there is 0 or 1 character left
        while (deque.size() > 1) {
            // Remove and compare characters from both ends
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }
}