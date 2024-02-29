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
        ListNode end = head;
        int length = 1;
        while (end.next != null) {
            end = end.next;
            length++;
        }
        end.next = head;

        k = k % length;
        ListNode endOfRotate = head;
        for (int i = 0; i < length - k - 1; i++) {
            endOfRotate = endOfRotate.next;
        }
        ListNode newHead = endOfRotate.next;
        endOfRotate.next = null;
        return newHead;
    }
}