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
            int sum = 0;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            sum += carry;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            ListNode currentNode = new ListNode(sum);
            current.next = currentNode;
            current = current.next;
        }
        return dummy.next;
    }
}