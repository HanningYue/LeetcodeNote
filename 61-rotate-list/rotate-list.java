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
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        ListNode lastNode = head;
        int listLength = 1;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            listLength++;
        }
        lastNode.next = head;
        k = k % listLength;

        int lengthToNewHead = listLength - k;
        ListNode endOfRotateList = head;
        for (int i = 0; i < lengthToNewHead - 1; i++) {
            endOfRotateList = endOfRotateList.next;
        }
        ListNode newHead = endOfRotateList.next;
        endOfRotateList.next = null;
        return newHead;
    }
}