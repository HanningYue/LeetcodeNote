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
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;

        for (int i = 0; i < left - 1; i++) {
            previous = previous.next;
        }
        ListNode start = previous.next;
        ListNode then = start.next;
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = previous.next;
            previous.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}