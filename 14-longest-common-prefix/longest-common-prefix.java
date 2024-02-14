//   012345
// 0 flower
// 1 flow
// 2 flight
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String currentString = strs[j];
                if (i >= currentString.length() || currentString.charAt(i) != c) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }
}