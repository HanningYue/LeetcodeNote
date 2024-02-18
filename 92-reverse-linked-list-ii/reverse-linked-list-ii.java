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

        ListNode listPrevious = previous;
        ListNode listEnd = current;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (listPrevious == null) {
            head = previous;
        } else {
            listPrevious.next = previous;
        }
        listEnd.next = current;
        return head;
    }
}