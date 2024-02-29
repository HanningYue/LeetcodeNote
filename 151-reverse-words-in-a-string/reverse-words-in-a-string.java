class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trim(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();        
    }
    private StringBuilder trim(String s) {
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
        int start = 0, end = 0;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }
}