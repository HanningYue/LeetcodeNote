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
        dummy.next = head;

        ListNode previous = dummy;
        for (int i = 0; i < left - 1; i++) {
            previous = previous.next;
        }

        ListNode start = previous.next;
        ListNode end = start;
        for (int i = 0; i < right - left; i++) {
            end = end.next;
        }
        ListNode secondHalf = end.next;
        end.next = null;


        ListNode reversedHead = reverse(start);
        previous.next = reversedHead;
        start.next = secondHalf;
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