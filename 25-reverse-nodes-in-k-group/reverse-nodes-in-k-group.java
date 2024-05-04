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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head, kth = head;
        for (int i = 0; i < k; i++) {
            if (kth == null) {
                return head;                
            }
            kth = kth.next;
        }
        ListNode reverseHead = reverseRange(current, kth);
        current.next = reverseKGroup(kth, k);
        return reverseHead;
    }
    private ListNode reverseRange(ListNode left, ListNode right) {
        ListNode previous = null, current = left;
        while (current != right) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}