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
        ListNode left = head, right = head;
        for (int i = 0; i < k; i++) {
            if (right == null) {
                return head;
            }
            right = right.next;
        }
        ListNode newHead = reverse(left, right);
        left.next = reverseKGroup(right, k);
        return newHead;
    }
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null, current = start;
        while (current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}