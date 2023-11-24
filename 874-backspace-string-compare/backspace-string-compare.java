class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sskip = 0, tskip = 0;
        int i = s.length() - 1, j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sskip++;
                    i--;
                } else if (sskip > 0) {
                    sskip--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tskip++;
                    j--;
                } else if (tskip > 0) {
                    tskip--;
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