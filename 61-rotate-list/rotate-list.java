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
        
        ListNode lastNode = head;
        int length = 1;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }    
        lastNode.next = head;

        k = k % length;
        k = length - k;
        ListNode newStart = head;
        ListNode previous = null;
        for (int i = 0; i < k; i++) {
            previous = newStart;
            newStart = newStart.next;
        }
        previous.next = null;
        return newStart;
    }
}