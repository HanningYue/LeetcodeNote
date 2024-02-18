class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int sPointer = 0, tPointer = 0;
        while (tPointer < t.length()) {
            char sC = s.charAt(sPointer);
            char tC = t.charAt(tPointer);
            if (tC == sC) {
                sPointer++;
                if (sPointer == s.length()) {
                    return true;
                }
            }
            tPointer++;
        }
        return false;
    }
}