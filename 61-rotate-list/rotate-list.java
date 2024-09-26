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

        ListNode lastNode = head, previous = null;
        int length = 0;
        while (lastNode != null) {
            previous = lastNode;
            lastNode = lastNode.next;
            length++;
        }
        previous.next = head;

        k = k % length;
        k = length - k;
        ListNode newHead = head;
        previous = null;
        for (int i = 0; i < k; i++) {
            previous = newHead;
            newHead = newHead.next;
        }
        previous.next = null;
        return newHead;
    }
}