class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int slow = 0, fast = 0;
        int res = 0; // 记录结果
        while (fast < s.length()) {
            char c = s.charAt(fast);
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(slow);
                
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
                slow++;
            }
            // 在这里更新答案
            res = Math.max(res, fast - slow + 1);
            fast++;
        }
        return res;
    }
}