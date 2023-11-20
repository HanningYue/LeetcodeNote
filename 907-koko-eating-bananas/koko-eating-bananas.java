/*
We need to find the pile with most banana
The low will be 0 and the high will be the pile with most banana 
    (Koko can eats 0 or at-Most pile banana in each hour)
求左边界,退出条件就是while (low < high), 判定条件 low = rate + 1
Mid will be the 'rate' of eating x-# of bananas, calculate by low + (high - low) / 2
我们找到总时间,对于每一个pile, 用Math.ceil() round up (因为Koko 每小时只吃一pile香蕉 不管RATE多少) 
如果时间大于h, 移动左边界+1,因为超时了 其他情况移动右边界
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        
        while (low < high) {
            int rate = low + (high - low) / 2;
            double totalTime = 0.0;
            for (int pile : piles) {
                totalTime += Math.ceil((double)pile / rate);
            }

            if (totalTime > h) {
                low = rate + 1;
            } else {
                high = rate;
            }
        }
        return low;
    }
}
