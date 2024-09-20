class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            int currentHand = hand[i];
            if (map.get(currentHand) == 0) {
                continue;
            }
            
            for (int j = 0; j < groupSize; j++) {
                int nextCard = currentHand + j;
                if (!map.containsKey(nextCard) || map.get(nextCard) == 0) {
                    return false;
                }
                map.put(nextCard, map.get(nextCard) - 1);
            }
        }
        return true;
    }
}