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
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        recursion(l1, l2, 0);
        return dummy.next;
    }
    private ListNode recursion(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int l1Value = l1 == null ? 0 : l1.val;
        int l2Value = l2 == null ? 0 : l2.val;

        int sum = l1Value + l2Value + carry;
        int remainder = sum % 10;
        carry = sum / 10;
        ListNode newNode = new ListNode(remainder);
        current.next = newNode;
        current = current.next;

        if (l1 != null && l2 != null) {
            return recursion(l1.next, l2.next, carry);
        } else if (l1 != null && l2 == null) {
            return recursion(l1.next, null, carry);
        } else if (l1 == null && l2 != null) {
            return recursion(null, l2.next, carry);
        } else {
            return recursion(null, null, carry);
        }
    }
}