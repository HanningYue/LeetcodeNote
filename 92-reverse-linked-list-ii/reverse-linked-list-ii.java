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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null, current = head;
        for (int i = 0; i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode previousOfSublist = previous;
        ListNode endOfSublist = current;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (previousOfSublist != null) {
            previousOfSublist.next = previous;
        } else {
            head = previous;
        }
        endOfSublist.next = current;
        return head;
    }
}