class Solution {
    public int totalFruit(int[] fruits) {
        int slow = 0, fast = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (fast < fruits.length) {
            int num = fruits[fast];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.size() > 2) {
                num = fruits[slow];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                slow++;
            }
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}