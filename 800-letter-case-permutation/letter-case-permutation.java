class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(s, 0, sb, result);
        return result;
    }
    private void backTrack(String s, int index, StringBuilder sb, List<String> result) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                backTrack(s, i + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);

                sb.append(Character.toLowerCase(c));
                backTrack(s, i + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            } 
            else {
                sb.append(c);
                backTrack(s, i + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}