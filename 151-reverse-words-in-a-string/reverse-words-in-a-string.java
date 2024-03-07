class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = build(s);
        reverseSB(sb, 0, sb.length() - 1);
        reverseWord(sb);
        return sb.toString();
    }
    private StringBuilder build(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (c == ' ' && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }
    private void reverseSB(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
    private void reverseWord(StringBuilder sb) {
        int wordStart = 0, wordEnd = 0;
        while (wordEnd < sb.length()) {
            while (wordEnd < sb.length() && sb.charAt(wordEnd) != ' ') {
                wordEnd++;
            }
            reverseSB(sb, wordStart, wordEnd - 1);
            wordStart = wordEnd + 1;
            wordEnd++;
        }
    }
}