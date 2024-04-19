class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            int currentCard = hand[i];
            if (map.get(currentCard) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
                int nextCard = currentCard + j;
                if (map.getOrDefault(nextCard, 0) == 0) {
                    return false;
                }
                map.put(nextCard, map.get(nextCard) - 1);
            }
        }
        return true;
    }
}