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
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carryToNext = 0;
        int currentSum = 0;

        while (l1 != null || l2 != null || carryToNext != 0) {
            if (l1 != null && l2 != null) {
                currentSum = l1.val + l2.val + carryToNext;
            } else if (l1 != null || l2 != null) {
                currentSum = (l1 == null) ? l2.val + carryToNext : l1.val + carryToNext;
            } else if (l1 == null && l2 == null) {
                currentSum = carryToNext;
            }

            int currentNodeVal = currentSum % 10;
            carryToNext = currentSum / 10;
            
            current.next = new ListNode(currentNodeVal);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;        
    }
}