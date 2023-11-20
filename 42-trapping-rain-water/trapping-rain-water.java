/**
    For current
    min(Max(left), Max(right)) - h[current]

input               0 1 0 2 1 0 1 3 2 1 2 1
maxLeft             0 0 1 1 2 2 2 2 3 3 3 3
maxRight            3 3 3 3 3 3 3 2 2 2 1 0
min(Left, Right)    0 0 1 1 2 2 2 2 2 2 1 0
Result =            0 0 1 0 1 2 1 0 0 1 0 0 = 1 + 1 + 2 + 1 + 1 = 6
O(n) O(n)
The amount of water that can be trapped at any given position is determined by the height of the shorter wall on either side of that position. Water will overflow from the shorter side, so the height of the shorter side acts as the limiting factor.
*/
class Solution {
    public int trap(int[] height) {
        int maxLeft = 0, maxRight = 0;
        int leftPointer = 0, rightPointer = height.length - 1;
        int result = 0;

        while (leftPointer < rightPointer) {
            if (height[leftPointer] < height[rightPointer]) {
                maxLeft = Math.max(maxLeft, height[leftPointer]);
                if (maxLeft > height[leftPointer]) {
                    result += maxLeft - height[leftPointer];            
                }
                leftPointer++;
            } else {
                maxRight = Math.max(maxRight, height[rightPointer]);
                if (maxRight > height[rightPointer]) {
                    result += maxRight - height[rightPointer];
                }
                rightPointer--;
            }
        }
        return result;
    }
}