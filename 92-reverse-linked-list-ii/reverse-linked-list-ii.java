/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        ListNode previousOfList = dummy;
        dummy.next = head;

        for (int i = 0; i < left - 1; i++) {
            previousOfList = previousOfList.next;
        }
        
        ListNode startOfReverse = previousOfList.next;
        ListNode endOfReverse = startOfReverse;
        for (int i = 0; i < right - left; i++) {
            endOfReverse = endOfReverse.next;
        }
        ListNode laterHalf = endOfReverse.next;
        endOfReverse.next = null;

        ListNode reversedHead = reverse(startOfReverse);
        previousOfList.next = reversedHead;
        startOfReverse.next = laterHalf;
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}