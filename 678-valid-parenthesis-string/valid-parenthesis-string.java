class Solution {
    public boolean checkValidString(String s) {
        int maxLeft = 0, minLeft = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minLeft++;
                maxLeft++;
            } else if (c == ')') {
                if (minLeft > 0) {
                    minLeft--;
                }
                maxLeft--;
            } else if (c == '*') {
                if (minLeft > 0) {
                    minLeft--;
                }
                maxLeft++;
            }
            if (maxLeft < 0) {
                return false;
            }
        }
        return minLeft == 0;
    }
}