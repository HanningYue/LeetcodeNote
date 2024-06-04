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

        ListNode tempPrevious = previous, tempCurrent = current;
        for (int i = left; i <= right; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (tempPrevious == null) {
            head = previous;
        } else {
            tempPrevious.next = previous;
        }
        tempCurrent.next = current;
        return head;
    }
}