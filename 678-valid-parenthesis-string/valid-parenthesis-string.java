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
        int maximumLeftBracket = 0;
        int minimumLeftBracket = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                maximumLeftBracket++;
                minimumLeftBracket++;
            } else if (c == ')') {
                if (minimumLeftBracket > 0) {
                    minimumLeftBracket--;
                }
                maximumLeftBracket--;
            } else if (c == '*') {
                if (minimumLeftBracket > 0) {
                    minimumLeftBracket--;
                }
                maximumLeftBracket++;
            }
            if (maximumLeftBracket < 0) {
                return false;
            }
        }
        return minimumLeftBracket == 0;
    }
}