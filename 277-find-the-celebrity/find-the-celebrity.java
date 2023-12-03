/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int other = 1; other < n; other++) {
            if (!knows(other, celebrity) || knows(celebrity, other)) {
                celebrity = other;
            }
        }

        for (int i = 0; i < n; i++) {
            if (celebrity == i) {
                continue;
            }
            if (!knows(i, celebrity) || knows(celebrity, i)) {
                return -1;
            }
        }
        return celebrity;
    }
}