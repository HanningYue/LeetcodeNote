/*
Three sum, [a, b, c, d, e, f, g, h, i, j, k, l, m, n]
            i  j  k
首先需要Arrays.sort(nums)
k每次向右走动，每一次iteration都check nums[i] + nums[j] + nums[k]// i = 0 // j = k - 1
ATTENTION!!查重时，如果k遇到duplicate， k++并且skip当前的iteration， 所以用while loop
                  如果i遇到duplicate, i++, ATTENTION!,最后i还要再次increase 到新的数字上
常规sum < > == 0 的操作
check如果等于0，加到result list
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int k = 2; k < nums.length; k++) {
            if (k + 1 < nums.length && nums[k] == nums[k + 1]) {
                continue;
            }
            
            int i = 0;
            int j = k - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i + 1 < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    i++;
                }
            }
        }
        return result;
    }
}