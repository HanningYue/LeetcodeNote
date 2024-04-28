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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode reverseSecondHalf = reverse(secondHalf);
        
        while (reverseSecondHalf != null && head != null) {
            ListNode firstNext = head.next;
            head.next = reverseSecondHalf;
            head = firstNext;

            ListNode secondNext = reverseSecondHalf.next;
            reverseSecondHalf.next = head;
            reverseSecondHalf = secondNext;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}