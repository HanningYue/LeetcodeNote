/**
minHeap or QuickSort
When quick sorting, 
[... kth ...]       Since position is index, we looking for the KTH, add 1 to index when comparing
To the left of kth number, are all the numbers greater than k
To the right of kth number, are all the numbers smaller than k
Use two pointer to find the range and swap helper function to quick sort
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int pos = position(nums, low, high);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 < k) {
                low = pos + 1;
            } else if (pos + 1 > k) {
                high = pos - 1;
            }
        }    
        return -1;
    }
    
    private int position(int[] nums, int low, int high) {
        int pivot = nums[low];
        int leftPointer = low + 1;
        int rightPointer = high;
        while (leftPointer <= rightPointer) {
            if (nums[leftPointer] < pivot && nums[rightPointer] > pivot) {
                swap(nums, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
            if (nums[leftPointer] >= pivot) {
                leftPointer++;
            }
            if (nums[rightPointer] <= pivot) {
                rightPointer--;
            }
        }
        swap(nums, low, rightPointer);
        return rightPointer;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}