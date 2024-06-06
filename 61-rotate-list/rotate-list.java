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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode originalHead = head, tail = null;
        while (originalHead != null) {
            tail = originalHead;
            originalHead = originalHead.next;
            length++;
        }
        tail.next = head;

        k = k % length;
        int startOfRotated = length - k;
        ListNode endOfRotated = null;
        for (int i = 0; i < startOfRotated; i++) {
            endOfRotated = head;
            head = head.next;
        }
        endOfRotated.next = null;
        return head;
    }
}