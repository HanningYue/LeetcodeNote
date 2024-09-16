class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = build(s);
        reverseSb(sb, 0, sb.length() - 1);
        reverseEachString(sb);
        return sb.toString();
    }
    private StringBuilder build(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--; 
        }

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
    private void reverseSb(StringBuilder sb, int left, int right) {
        while (left <= right) {
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            left++;
            right--;
        }
    }
    private void reverseEachString(StringBuilder sb) {
        int wordStart = 0, wordEnd = 0;
        while (wordEnd < sb.length()) {
            while (wordEnd < sb.length() && sb.charAt(wordEnd) != ' ') {
                wordEnd++;
            }
            reverseSb(sb, wordStart, wordEnd - 1);
            wordStart = wordEnd + 1;
            wordEnd++;
        }
    }
}