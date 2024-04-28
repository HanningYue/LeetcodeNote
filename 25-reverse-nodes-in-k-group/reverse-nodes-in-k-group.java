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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode kth = current;
        for (int i = 0; i < k; i++) {
            if (kth == null) {
                return current;
            }
            kth = kth.next;
        }

        ListNode reverseHead = reverseRange(current, kth);
        head.next = reverseKGroup(kth, k);
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