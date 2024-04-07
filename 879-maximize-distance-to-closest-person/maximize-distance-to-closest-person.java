class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int lastOccupied = -1;
        
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (lastOccupied == -1) {
                    maxDistance = i;
                } else {
                    maxDistance = Math.max(maxDistance, (i - lastOccupied) / 2);
                }
                lastOccupied = i;
            }
        }
        if (seats[seats.length - 1] == 0) {
            maxDistance = Math.max(maxDistance, seats.length - 1 - lastOccupied);
        }
        return maxDistance;
    }
}