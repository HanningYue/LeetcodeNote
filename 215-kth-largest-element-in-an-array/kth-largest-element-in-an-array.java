/**
1. want to find the SORTED kth largest element in the num array
2. maxHeap or minHeap, poll maxHeap and minus k while k is greater than 1
3. return the kth largest element
*/
class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int quick_select(int[] nums, int lo, int hi, int k) {
        int lt = lo, gt = hi;
        int v = nums[hi];
        int i = hi - 1;
        while (i >= lt) {
            int cmp = nums[i] - v;
            if      (cmp < 0) swap(nums, lt++, i);
            else if (cmp > 0) swap(nums, i--, gt--);
            else              i--;
        }
        if (k < lt) return quick_select(nums, lo, lt - 1, k);
        else if (k > gt) return quick_select(nums, gt + 1, hi, k);
        else return v;
    }
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quick_select(nums, 0, nums.length - 1, k);
    }
}