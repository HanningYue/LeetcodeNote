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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            if (l1 != null) {
                l1 = l1.next;
            }
            int l2Val = l2 == null ? 0 : l2.val;
            if (l2 != null) {
                l2 = l2.next;
            }
            
            int nodeValue = l1Val + l2Val + carry;
            carry = nodeValue / 10;
            ListNode node = new ListNode(nodeValue % 10);
            current.next = node;
            current = current.next;
        }
        return dummy.next;
    }
}