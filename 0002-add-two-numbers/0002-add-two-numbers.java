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
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum1 = (l1 != null) ? l1.val : 0;
            int sum2 = (l2 != null) ? l2.val : 0;
            int total = sum1 + sum2 + carry;
            carry = total / 10;
            
            ListNode newHead = new ListNode(total % 10);
            current.next = newHead;
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}