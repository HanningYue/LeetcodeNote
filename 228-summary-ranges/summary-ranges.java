class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int tempIndex = i;
            sb.append(nums[tempIndex]);
            while (tempIndex < n - 1 && nums[tempIndex + 1] == nums[tempIndex] + 1) {
                tempIndex++;
            }
            if (tempIndex == i) {
                result.add(sb.toString());
                continue;
            } else {
                sb.append("->");
                sb.append(nums[tempIndex]);
                result.add(sb.toString());
                i = tempIndex;
            }
        }
        return result;
    }
}