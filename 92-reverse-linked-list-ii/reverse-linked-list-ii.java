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
        if (left == right) {
            return head;
        }
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }
        ListNode previousBeforeSublist = previous;
        ListNode endOfSublist = current;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (previousBeforeSublist != null) {
            previousBeforeSublist.next = previous;
        } else {
            head = previous;
        }
        endOfSublist.next = current;
        return head;
    }
}