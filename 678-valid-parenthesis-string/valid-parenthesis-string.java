/**
O(n) Linear Time
Minimum and Maximum is the potential left open bracket, not necessarily the real number
This part if (minimum > 0) { minimum--; } is essentially saying if we have any open left brackets or "*", which can potentially act as "(", we match them with the current right bracket or "*". If we didn't decrement minimum when we encounter a "*" or ")", we could end up with an incorrect surplus of open brackets.
'('
    minimum++
    maximum++
')'
    minimum-- if minimum is greater than 0
    maximum--
'*'
    minimum-- if minimum is greater than 0, * == ) to cancel a (
    maximum++ * == (
At any time, ( needs to be greater than )
*/
class Solution {
    public boolean checkValidString(String s) {
        int minLeft = 0, maxLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                minLeft++;
                maxLeft++;
            } else if (s.charAt(i) == ')') {
                if (minLeft > 0) {
                    minLeft--;
                }
                maxLeft--;
            } else if (s.charAt(i) == '*'){
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