class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int pointer = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            pointer++;
        }
        int result = right << pointer;
        return result;
    }
}