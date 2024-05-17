class Solution {
    Random rand = new Random();
    Map<Integer, Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] temp = new int[map.size()];
        int index = 0;
        for (int num : map.keySet()) {
            temp[index++] = num;
        }
        quickSelect(temp, 0, temp.length - 1, temp.length - k);
        return Arrays.copyOfRange(temp, temp.length - k, temp.length);
    }
    private void quickSelect(int[] temp, int left, int right, int targetK) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(temp, left, right);
        if (pivotIndex == targetK) {
            return;
        } else if (pivotIndex < targetK) {
            quickSelect(temp, pivotIndex + 1, right, targetK);
        } else if (pivotIndex > targetK) {
            quickSelect(temp, left, pivotIndex - 1, targetK);
        }
    }
    private int partition(int[] temp, int left, int right) {
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotFrequency = map.get(temp[pivotIndex]);
        swap(temp, pivotIndex, right);

        int leftP = left;
        for (int i = left; i < right; i++) {
            if (map.get(temp[i]) < pivotFrequency) {
                swap(temp, leftP, i);
                leftP++;
            }
        }
        swap(temp, leftP, right);
        return leftP;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}