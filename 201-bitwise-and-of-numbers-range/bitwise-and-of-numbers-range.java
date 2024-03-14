// 1 & 1 = 1, 0 & 1 = 0, 0 & 0 = 0
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int pointer = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            pointer++;
        }
        left = left << pointer;
        return left;
    }
}