/**
Since roman letter writtern from largest to smallest, traverse backwards. 
Anything current that are smaller than the previous are categorized as IV, IX, XL, XC, CD, CM
In the above 6 instances, add previous, minus current to get correct result. All other scenario 
Just add up current to get final result
*/
class Solution {
    public int romanToInt(String s) {
        int prev = 0, result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanToInt(s.charAt(i));
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }
    private int romanToInt(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}