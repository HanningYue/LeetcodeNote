class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0, lastPerson = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (lastPerson == -1) {
                    maxDistance = i;
                } else if (lastPerson != -1) {
                    maxDistance = Math.max(maxDistance, (i - lastPerson) / 2);
                }
                lastPerson = i;
            }
        }

        if (seats[seats.length - 1] == 0) {
            maxDistance = Math.max(maxDistance, seats.length - 1 - lastPerson);
        }
        return maxDistance;
    }
}