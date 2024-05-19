class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char firstChar = first.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                String second = strs[j];
                if (i >= second.length() || firstChar != second.charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}