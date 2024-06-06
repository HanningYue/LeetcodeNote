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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                current.next = head.next;
            }
            else {
                current = current.next;
            }

            head = head.next;
        }
        return dummy.next;
    }
}