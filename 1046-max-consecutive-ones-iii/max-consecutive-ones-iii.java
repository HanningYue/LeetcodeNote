class Solution {
    public int longestOnes(int[] nums, int k) {
        int slow = 0, fast = 0;
        int result = 0, oneFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (fast < nums.length) {
            int num = nums[fast];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (num == 1) {
                oneFreq = map.get(num);
            }
            if (fast - slow + 1 - oneFreq > k) {
                num = nums[slow];
                map.put(num, map.get(num) - 1);
                slow++;
            }
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}