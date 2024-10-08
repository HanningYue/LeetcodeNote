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
        ListNode previousEnd = null, startOfCurrent = head;
        ListNode current = head;
        while (current != null) {
            ListNode check = current;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    return head;
                }
                check = check.next;
            }
            
            ListNode previous = null;
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (previousEnd == null) {
                head = previous;
            } else if (previousEnd != null) {
                previousEnd.next = previous;
            }
            previousEnd = startOfCurrent;
            startOfCurrent.next = current;
            startOfCurrent = current;
        }
        return head;
    }
}