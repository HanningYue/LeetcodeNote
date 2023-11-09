/*
We can not sort the array, also there might be duplicate elements in the nums
1. Thus, apply Set<Integer>, fill set with all elements in nums
2. For each current number in nums,
    For each iteration, if set does not contains current number - 1 (means we start a new sequence)
        reset length to 0, check while set contains current number + length, increase length by 1
            update maxlength
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) 
            set.add(num);
        
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 0;
                while (set.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}