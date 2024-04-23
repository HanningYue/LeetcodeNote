// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> result = new ArrayList<>();
//         for (int k = 0; k < nums.length - 2; k++) {
//             if (k > 0 && nums[k - 1] == nums[k]) {
//                 continue;
//             }

//             int i = k + 1, j = nums.length - 1;
//             while (i < j) {
//                 int sum = nums[i] + nums[j] + nums[k];
//                 if (sum == 0) {
//                     result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                     while (i + 1 < j && nums[i + 1] == nums[i]) {
//                         i++;
//                     }
//                     while (i + 1 < j && nums[j - 1] == nums[j]) {
//                         j--;
//                     }
//                     i++;
//                     j--;
//                 } else if (sum < 0) {
//                     i++;
//                 } else if (sum > 0) {
//                     j--;
//                 }
//             }
//         }
//         return result;
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}