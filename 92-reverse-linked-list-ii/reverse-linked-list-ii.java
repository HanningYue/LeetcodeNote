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
        ListNode current = head, previous = null;
        for (int i = 0; i < left - 1 && current != null; i++) {
            previous = current;
            current = current.next;
        }

        ListNode oneBeforeSublist = previous;
        ListNode endOfSublist = current;
        for (int i = 0; i < right - left + 1 && current != null; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (oneBeforeSublist != null) {
            oneBeforeSublist.next = previous;
        } else {
            head = previous;
        }
        endOfSublist.next = current;
        return head;
    }
}