class Solution {
    Map<Integer, Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] tempArray = new int[map.size()];
        int index = 0;
        for (int num : map.keySet()) {
            tempArray[index++] = num;
        }

        int topKIndex = tempArray.length - k;
        quickSelect(tempArray, 0, tempArray.length - 1, topKIndex);

        return Arrays.copyOfRange(tempArray, topKIndex, tempArray.length);
    }

    private void quickSelect(int[] tempArray, int left, int right, int k) {
        if (left < right) {
            int pivotIndex = partition(tempArray, left, right);
            if (pivotIndex == k) {
                return;
            } else if (pivotIndex < k) {
                quickSelect(tempArray, pivotIndex + 1, right, k);
            } else {
                quickSelect(tempArray, left, pivotIndex - 1, k);
            }
        }
    }

    private int partition(int[] tempArray, int left, int right) {
        int pivotFreq = map.get(tempArray[right]);
        int leftP = left;
        
        for (int i = left; i <= right; i++) {
            if (map.get(tempArray[i]) < pivotFreq) {
                swap(tempArray, leftP, i);
                leftP++;
            }
        }
        swap(tempArray, leftP, right);
        return leftP;
    }

    private void swap(int[] tempArray, int left, int right) {
        int temp = tempArray[left];
        tempArray[left] = tempArray[right];
        tempArray[right] = temp;
    }
}