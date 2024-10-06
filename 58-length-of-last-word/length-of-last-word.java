class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s.isEmpty()) {
            return 0;
        }

        int wordEnd = s.length() - 1;
        while (s.charAt(wordEnd) == ' ') {
            wordEnd--;
        }

        int wordEndCopy = wordEnd;
        while (wordEnd >= 0 && s.charAt(wordEnd) != ' ') {
            wordEnd--;
        }

        return wordEndCopy - wordEnd;
    }
}