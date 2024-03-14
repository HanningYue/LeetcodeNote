/**
XOR ^ :  1 ^ 1 = 0       0 ^ 0 = 0         1 ^ 0 = 1
If two numbers are identical, a ^ a = 0
*/
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}