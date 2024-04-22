class Solution {
    public boolean checkValidString(String s) {
        int minLeft = 0, maxLeft = 0;

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
            //If anytime maxLeft is negative, not possible immediately
            if (maxLeft < 0) {
                return false;
            }
        }
        return minLeft == 0;
    }
}