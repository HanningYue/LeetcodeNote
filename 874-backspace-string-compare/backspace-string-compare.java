class Solution {
    public boolean backspaceCompare(String s, String t) {
        int pointer1 = s.length() - 1, pointer2 = t.length() - 1;
        while (pointer1 >= 0 || pointer2 >= 0) {
            int validOne = nextIdx(s, pointer1);
            int validTwo = nextIdx(t, pointer2);
            if (validOne < 0 && validTwo < 0) {
                return true;
            }
            if (validOne < 0 || validTwo < 0) {
                return false;
            }
            if (s.charAt(validOne) != t.charAt(validTwo)) {
                return false;
            }
            pointer1 = validOne - 1;
            pointer2 = validTwo - 1;
        }
        return true;
    }
    private int nextIdx(String s, int idx) {
        int backSpace = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                backSpace++;
            } else if (backSpace > 0) {
                backSpace--;
            } else if (backSpace == 0 && s.charAt(idx) != '#') {
                break;
            }
            idx--;
        }
        return idx;
    }
}