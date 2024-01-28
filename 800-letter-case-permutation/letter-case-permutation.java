class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(s, sb, result, 0);
        return result;
    }
    private void backTrack(String s, StringBuilder sb, List<String> result, int index) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            sb.append(Character.toLowerCase(c));
            backTrack(s, sb, result, index + 1);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toUpperCase(c));
            backTrack(s, sb, result, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(c);
            backTrack(s, sb, result, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}