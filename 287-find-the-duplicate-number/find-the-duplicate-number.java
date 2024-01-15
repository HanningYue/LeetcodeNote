class Solution {
    public int findDuplicate(int[] nums) {
        int slowP = 0, fastP = 0;
        do {
            slowP = nums[slowP];
            fastP = nums[nums[fastP]];
        } while (slowP != fastP);

        int newP = 0;
        do {
            newP = nums[newP];
            slowP = nums[slowP];
        } while (newP != slowP);

        return newP;
    }
}