class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() == 0 && t.length() != 0) {
            return true;
        } else if (s.length() != 0 && t.length() == 0) {
            return false;
        }

        int sPointer = 0, tPointer = 0;
        while (tPointer < t.length()) {
            char tChar = t.charAt(tPointer);
            char sChar = s.charAt(sPointer);
            if (tChar == sChar) {
                sPointer++;
                tPointer++;
                if (sPointer == s.length()) {
                    return true;
                }
            } else {
                tPointer++;
            }
        }
        return false;
    }
}