class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            if (tails.isEmpty() || num > tails.get(tails.size() -  1)) {
                tails.add(num);
            } else {
                int left = 0, right = tails.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails.get(mid) < num) {
                        left = mid + 1;
                    } else if (tails.get(mid) >= num) {
                        right = mid;
                    }
                }
                tails.set(right, num);
            }
        }
        return tails.size();
    }
}