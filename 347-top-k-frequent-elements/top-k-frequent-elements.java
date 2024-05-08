import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create an array of unique numbers
        int n = frequencyMap.size();
        int[] unique = new int[n];
        int index = 0;
        for (int num : frequencyMap.keySet()) {
            unique[index++] = num;
        }

        // Step 3: Find the kth most frequent using quick select (transformed to find k largest)
        int target = unique.length - k;
        quickSelect(unique, frequencyMap, 0, unique.length - 1, target);

        // Step 4: Prepare result
        int[] result = Arrays.copyOfRange(unique, target, unique.length);
        return result;
    }

    private void quickSelect(int[] unique, Map<Integer, Integer> freq, int left, int right, int k) {
        if (left < right) {
            int pivotIndex = partition(unique, freq, left, right);
            if (pivotIndex == k) {
                return;
            } else if (pivotIndex < k) {
                quickSelect(unique, freq, pivotIndex + 1, right, k);
            } else {
                quickSelect(unique, freq, left, pivotIndex - 1, k);
            }
        }
    }

    private int partition(int[] unique, Map<Integer, Integer> freq, int left, int right) {
        int pivotFreq = freq.get(unique[right]);
        int i = left;
        for (int j = left; j <= right; j++) {
            if (freq.get(unique[j]) < pivotFreq) {
                swap(unique, i, j);
                i++;
            }
        }
        swap(unique, i, right);
        return i;
    }

    private void swap(int[] unique, int left, int right) {
        int temp = unique[left];
        unique[left] = unique[right];
        unique[right] = temp;
    }
}
