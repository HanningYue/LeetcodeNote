class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            map.put(loser, map.getOrDefault(loser, 0) + 1);
            set.add(winner);
            set.add(loser);
        }
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (int player : set) {
            if (!map.containsKey(player)) {
                zero.add(player);
            } else if (map.get(player) == 1) {
                one.add(player);
            }
        }
        Collections.sort(zero);
        Collections.sort(one);
        return Arrays.asList(zero, one);
    }
}