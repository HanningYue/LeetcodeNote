/*
Rate : k/hour, want to show the minimum rate K so bananas == 0 within h hours
We need to find the pile with most banana
The low and high in this context will be 0 and the pile with most banana 
    (Koko can eats 0 or at-Most pile banana in each hour)
因为要找minimum integer k,所以求左边界,退出条件就是while (low <= high)
Mid will be the RATE of eating MEADIAN number of bananas, calculate by low + (high - low) / 2
我们找到总时间,对于每一个pile, 用Math.ceil() round up (因为Koko 每小时只吃一pile香蕉 不管RATE多少) the time finish this pile with current RATE
如果时间等于或小于h, 把RATE减1 因为要找到最小的RATE
    Total / rate = time , Total 不变 Time越大RATE越小
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(pile, high);
        }

        while (low < high) {
            int speed = low + (high - low) / 2;
            double time = 0;
            for (int pile : piles) {
                time += Math.ceil((double) pile / speed);
            }
            
            if (time > h) {
                low = speed + 1;
            } else {
                high = speed;
            }
        }
        return low;
    }
}
