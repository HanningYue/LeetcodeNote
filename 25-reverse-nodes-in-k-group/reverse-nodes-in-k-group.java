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
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode check = current;
            int count = 0;
            for (int i = 0; i < k && check != null; i++) {
                check = check.next;
                count++;
            }
            if (count < k) {
                break;
            }
            ListNode previousOfSublist = previous;
            ListNode endOfSublist = current;
            for (int i = 0; i < k && current != null; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            if (previousOfSublist != null) {
                previousOfSublist.next = previous;
            } else {
                head = previous;
            }
            endOfSublist.next = current;
            previous = endOfSublist;
        }
        return head;
    }
}