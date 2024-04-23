class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            // pos + 1 就是第几大数
            int pos = findPosition(nums, left, right);
            if(pos + 1 == k){
                return nums[pos];
            } else if(pos + 1 > k){ // 选定的数字小了, 结果在 pos 左边
                right = pos - 1;
            } else if (pos + 1 < k){
                left = pos + 1; // 选定的数字大了, 结果在 pos 右边
            }
        }
        return -1;
    }

    private int findPosition(int[] nums, int left, int right){
        // 把nums[left]这个数当作pivot
        int curr = nums[left];

        int l = left + 1;
        int r = right;
        // 使得 curr 左边的值都大于它, curr右边的值都小于它
        // 要使用 <=, 否则[2,1] 1 这种情况会报错
        while(l <= r){
            if(nums[l] < curr && nums[r] > curr){
                swap(nums, l, r);
                l++;
                r--;
            }
            // 跳过符合条件的值
            if(nums[l] >= curr) l++;
            if(nums[r] <= curr) r--;
        }

        // 把curr放到对的位置
        // r指向第一个比curr大的数, 所以要让curr和r交换
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}