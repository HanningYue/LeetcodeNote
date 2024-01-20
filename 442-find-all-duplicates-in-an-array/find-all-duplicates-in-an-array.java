class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int suppose = nums[i] - 1;
            if (nums[suppose] != nums[i]) {
                int temp = nums[suppose];
                nums[suppose] = nums[i];
                nums[i] = temp;
            }
            else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 2) {
                result.add(key);
            }
        }
        return result;
    }
}