import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] count;
    private int[] indexes;
    private int[] tempIndexes;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        indexes = new int[n];
        tempIndexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        System.arraycopy(indexes, start, tempIndexes, start, end - start + 1);

        int left = start, right = mid + 1;
        int pointer = start;

        while (left <= mid && right <= end) {
            if (nums[tempIndexes[left]] <= nums[tempIndexes[right]]) {
                // Count smaller elements on the right side
                count[tempIndexes[left]] += right - mid - 1;
                indexes[pointer++] = tempIndexes[left++];
            } else {
                indexes[pointer++] = tempIndexes[right++];
            }
        }

        while (left <= mid) {
            count[tempIndexes[left]] += end - mid;
            indexes[pointer++] = tempIndexes[left++];
        }

        while (right <= end) {
            indexes[pointer++] = tempIndexes[right++];
        }
    }
}
