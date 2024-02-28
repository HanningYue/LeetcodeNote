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
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (kth == null) {
                break;
            }
            kth = kth.next;
            count++;
        }
        if (count == k) {
            ListNode reverseHead = reverse(current, kth);
            head.next = reverseKGroup(kth, k);
            return reverseHead;
        }
        return head;
    }
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode current = start;
        ListNode prev = null;
        while (current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}