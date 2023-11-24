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
        int left = 0, right = 0;
        int steps = 0;
        while (right < nums.length - 1) {
            int furthest = 0;
            for (int i = left; i <= right; i++) {
                furthest = Math.max(furthest, nums[i] + i);
            }
            left = right + 1;
            right = furthest;
            steps++;
        }
        return steps;
    }
}