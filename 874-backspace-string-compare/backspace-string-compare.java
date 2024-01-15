class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#' && sbOne.length() != 0) {
                sbOne.deleteCharAt(sbOne.length() - 1);
            } else if (c != '#') {
                sbOne.append(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#' && sbTwo.length() != 0) {
                sbTwo.deleteCharAt(sbTwo.length() - 1);
            } else if (c != '#') {
                sbTwo.append(c);
            }
        }
        return sbOne.toString().equals(sbTwo.toString());
    }
}