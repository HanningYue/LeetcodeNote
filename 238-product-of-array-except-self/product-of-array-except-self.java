class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        int runningProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = runningProduct;
            runningProduct = runningProduct * nums[i];
        }

        runningProduct = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i] * runningProduct;
            runningProduct = runningProduct * nums[i];
        }
        
        return result;
    }
}
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
        
//         int[] prefix = new int[n];
//         prefix[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             prefix[i] = prefix[i - 1] * nums[i];
//         }

//         int[] suffix = new int[n];
//         suffix[n - 1] = nums[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             suffix[i] = suffix[i + 1] * nums[i];
//         }

//         int[] result = new int[n];
//         result[0] = suffix[1];
//         result[n - 1] = prefix[n - 2];
//         for (int i = 1; i < n - 1; i++) {
//             result[i] = prefix[i - 1] * suffix[i + 1];
//         }
//         return result;
//     }
// }