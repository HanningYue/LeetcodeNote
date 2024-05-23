class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = nums[i];
            sb.append(start);
            while (i < n - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (nums[i] == start) {
                result.add(sb.toString());
                continue;
            } else {
                sb.append("->");
                sb.append(nums[i]);
                result.add(sb.toString());
            }
        }
        return result;
    }
}