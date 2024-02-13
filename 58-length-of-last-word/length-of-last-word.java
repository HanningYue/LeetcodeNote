/*
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int slow = s.length() - 1, fast = s.length() - 1;
        while (fast >= 0) {
            if (s.charAt(fast) != ' ') {
                slow = fast;
                while (s.charAt(fast) != ' ' && fast > 0) {
                    fast--;
                }
                if (s.charAt(fast) == ' ') {
                    length = slow - fast;
                } else if (fast == 0) {
                    length = slow - fast + 1;
                }
                break;
            }
            fast--;
        }
        return length;
    }
}
*/
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}