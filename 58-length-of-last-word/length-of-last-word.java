class Solution {
    public int lengthOfLastWord(String s) {
        int lastIndex = s.length() - 1;
        while (lastIndex >= 0 && s.charAt(lastIndex) == ' ') {
            lastIndex--;
        }
        int length = 0;
        while (lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            length++;
            lastIndex--;
        }
        return length;
    }
}