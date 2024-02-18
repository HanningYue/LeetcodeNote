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

        ListNode previous = null, start = head;
        for (int i = 0; i < left - 1; i++) {
            previous = start;
            start = start.next;
        }

        ListNode startOfList = previous;
        ListNode endOfList = start;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = start.next;
            start.next = previous;
            previous= start;
            start = next;
        }

        if (startOfList == null) {
            head = previous;
        } else {
            startOfList.next = previous;
        }
        endOfList.next = start;
        return head;
    }
}