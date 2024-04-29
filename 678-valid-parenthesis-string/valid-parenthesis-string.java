class Solution {
    public boolean checkValidString(String s) {
        int maxLeft = 0, minLeft = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                maxLeft++;
                minLeft++;
            } else if (c == ')') {
                maxLeft--;
                if (minLeft > 0) {
                    minLeft--;
                }
            } else if (c == '*') {
                maxLeft++;
                if (minLeft > 0) {
                    minLeft--;
                }
            }
            if (maxLeft < 0) {
                return false;
            }
        }
        return minLeft == 0;
    }
}