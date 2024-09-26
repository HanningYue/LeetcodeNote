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
        ListNode previous = null, current = head;
        for (int i = 0; i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode previousEnd = previous, startOfCurrent = current;
        for (int i = left; i <= right; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if (previousEnd == null) {
            head = previous;
        } else {
            previousEnd.next = previous;
        }
        startOfCurrent.next = current;
        return head;
    }
}