/*
Three sum, [a, b, c, d, e, f, g, h, i, j, k, l, m, n]
            i  j  k
首先需要Arrays.sort(nums), i = 0, j = k - 1;
CHECK DUPLICATE
k每次向右走动，每一次iteration都check duplicate, while (k + 1 < nums.length),如果相同，跳过当前k, (continue)
ATTENTION!!当遇到结果时，因为是sorted， 查重复 i++ and i + 1 < j ATTENTION!,最后i还要再次increase 到新的数字上
常规sum < or > or == 0 的操作
return时 return Arrays.asList
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 2; k < nums.length; k++) {
            if (k + 1 < nums.length && nums[k + 1] == nums[k]) {
                continue;
            }
            int i = 0;
            int j = k - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i + 1 < j && nums[i + 1] == nums[i]) {
                        i++;   
                    }
                    i++;
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }
}