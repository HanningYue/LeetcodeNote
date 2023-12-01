/** 
所有num加入set
在set内 保持当前num不变 从每一个sequence最小数算起(!set.contains(num - 1)), 如果set包含当前num + 当前length， 更新maxlength
Update maxLength for each num - 1
return maxLength
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 0;
                while (set.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}