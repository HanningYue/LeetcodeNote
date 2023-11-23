/**
Find the MINIMUM steps to reach last index, use one-d array BFS
2 3 1 1 4
*
  & &
    % % %
* & and % are windows
Left and Right pointer, iterate the array while right pointer is less than last index, declear a variable furthest to mark the furthest the point can reach at EACH Index 
inside (left, right) window
    Find the furthest using Math.max()
    Update left to be right + 1 and right to be the furthest
    Update count of steps
*/
class Solution {
    public int jump(int[] nums) {
        int leftPointer = 0, rightPointer = 0;
        int step = 0;

        while (rightPointer < nums.length - 1) {
            int furthest = 0;
            for (int i = leftPointer; i <= rightPointer; i++) {
                furthest = Math.max(furthest, nums[i] + i);
            }
            leftPointer = rightPointer + 1;
            rightPointer = furthest;
            step++;
        }
        return step;
    }
}
