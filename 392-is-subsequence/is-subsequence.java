class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;
        while (sPointer < s.length() && tPointer < t.length()) {
            char tChar = t.charAt(tPointer);
            char sChar = s.charAt(sPointer);
            if (tChar == sChar) {
                tPointer++;
                sPointer++;
            } else {
                tPointer++;
            }
        }
        return sPointer == s.length();
    }
}