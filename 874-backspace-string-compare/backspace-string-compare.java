class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sCount = 0, tCount = 0;
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sCount++;
                    i--;
                } else if (sCount > 0) {
                    sCount--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tCount++;
                    j--;
                } else if (tCount > 0) {
                    tCount--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}