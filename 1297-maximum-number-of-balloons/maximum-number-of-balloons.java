class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minTimes = Integer.MAX_VALUE;
        minTimes = Math.min(minTimes, map.getOrDefault('b', 0));
        minTimes = Math.min(minTimes, map.getOrDefault('a', 0));
        minTimes = Math.min(minTimes, map.getOrDefault('l', 0) / 2);
        minTimes = Math.min(minTimes, map.getOrDefault('o', 0) / 2);
        minTimes = Math.min(minTimes, map.getOrDefault('n', 0));
        return minTimes;
    }
}