class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            String currentInterval = "";
            int a = nums[i];
            currentInterval += String.valueOf(nums[i]);
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (nums[i] == a) {
                result.add(currentInterval);
                continue;
            } 
            else {
                currentInterval = currentInterval + "->" + String.valueOf(nums[i]);
                result.add(currentInterval);
            }
        }
        return result;
    }
}