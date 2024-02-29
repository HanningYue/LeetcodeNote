class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trim(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();        
    }
    private StringBuilder trim(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            }
            else if (c == ' ' && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }
    private void reverse(StringBuilder sb, int left, int right) {
        while (left <= right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
    private void reverseEachWord(StringBuilder sb) {
        int wordStart = 0, wordEnd = 0;
        while (wordStart < sb.length()) {
            while (wordEnd < sb.length() && sb.charAt(wordEnd) != ' ') {
                wordEnd++;
            }
            reverse(sb, wordStart, wordEnd - 1);
            wordStart = wordEnd + 1;
            wordEnd = wordEnd + 1;
        }
    }
}