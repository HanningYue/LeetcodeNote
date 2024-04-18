class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tail = new ArrayList<>();
        for (int num : nums) {
            if (tail.isEmpty() || num > tail.get(tail.size() - 1)) {
                tail.add(num);
            } else {
                int left = 0, right = tail.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tail.get(mid) >= num) {
                        right = mid;
                    } else if (tail.get(mid) < num) {
                        left = mid + 1;
                    }
                }
                tail.set(left, num);
            }
        }
        return tail.size();
    }
}