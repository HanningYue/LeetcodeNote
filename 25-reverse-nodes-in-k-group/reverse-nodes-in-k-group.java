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
        ListNode nextGroupStart = head;
        for (int i = 0; i < k; i++) {
            if (nextGroupStart == null) {
                return head;
            }
            nextGroupStart = nextGroupStart.next;
        }

        ListNode reverseHead = reverse(head, nextGroupStart);
        head.next = reverseKGroup(nextGroupStart, k);
        return reverseHead;
    }
    private ListNode reverse(ListNode left, ListNode right) {
        ListNode current = left, previous = null;
        while (current != right) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}