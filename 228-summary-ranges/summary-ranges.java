class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int currentStart = i;
            int currentEnd = i;
            StringBuilder sb = new StringBuilder();
            while (currentEnd + 1 < nums.length && nums[currentEnd + 1] == nums[currentEnd] + 1) {
                currentEnd++;
            }
            if (currentStart == currentEnd) {
                sb.append(nums[currentStart]);
            } else {
                sb.append(nums[currentStart]);
                sb.append("->");
                sb.append(nums[currentEnd]);
            }
            result.add(sb.toString());
            i = currentEnd + 1;
        }
        return result;
    }
}