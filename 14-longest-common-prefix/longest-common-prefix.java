class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                String nextString = strs[j];
                if (i >= nextString.length() || nextString.charAt(i) != current) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }
}