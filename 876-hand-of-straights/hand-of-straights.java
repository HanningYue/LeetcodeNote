/**
Use a HashMap {card, frequency}
Sort the hand, check frequency, because we always want the minimum card to fill our groudSize
If frequency 0, continue;
Fill up groupSize
    currentCard = hand[i] + j, because consecutive number, so just add j
    check currentCard frequency, if non-exit in the initial map Init, return false
    decrease frequency by 1
*/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>(); //{card, frequency}
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (map.get(hand[i]) == 0) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int nextCard = hand[i] + j;
                if (map.getOrDefault(nextCard, 0) == 0) {
                    return false;
                }
                map.put(nextCard, map.get(nextCard) - 1);
            }
        }
        return true;
    }
}