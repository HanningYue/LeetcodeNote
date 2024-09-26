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
        ListNode previousEnd = null;
        ListNode current = head;
        for (int i = 0; i < left - 1; i++) {
            previousEnd = current;
            current = current.next;
        }
        ListNode currentCopy = current;
        
        ListNode previous = null;
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
        
        currentCopy.next = current;
        return head;
    }
}