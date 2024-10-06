class Solution {
    public int lengthOfLastWord(String s) {
        int wordStart = s.length() - 1;
        while (s.charAt(wordStart) == ' ') {
            wordStart--;
        }

        int wordEnd = wordStart;
        while (wordStart >= 0 && s.charAt(wordStart) != ' ') {
            wordStart--;
        }
        return wordEnd - wordStart;
    }
}