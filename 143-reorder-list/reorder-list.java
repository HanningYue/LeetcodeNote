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
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfStart = reverse(slow);
        while (head != null && secondHalfStart != null) {
            ListNode temp = head.next;
            head.next = secondHalfStart;
            head = temp;

            temp = secondHalfStart.next;
            secondHalfStart.next = head;
            secondHalfStart = temp;
        }
        if (head != null) {
            head.next = null;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}