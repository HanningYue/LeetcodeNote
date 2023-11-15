/**
要增加新的node 所以dummy node 
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int p1 = (l1 == null) ? 0 : l1.val;
            int p2 = (l2 == null) ? 0 : l2.val;
            int total = p1 + p2 + carry;
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