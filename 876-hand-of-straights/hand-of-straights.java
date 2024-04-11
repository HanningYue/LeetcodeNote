class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (map.get(hand[i]) == 0) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int consecutive = hand[i] + j;
                if (map.getOrDefault(consecutive, 0) == 0) {
                    return false;
                }

                map.put(consecutive, map.get(consecutive) - 1);
            }
        }
        return true;
    }
}