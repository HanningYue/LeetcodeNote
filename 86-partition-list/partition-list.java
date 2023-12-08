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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerDummy = new ListNode(-1);
        ListNode greaterDummy = new ListNode(-1);
        ListNode current1 = smallerDummy, current2 = greaterDummy;
        
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                current2.next = p;
                current2 = current2.next;
            } else {
                current1.next = p;
                current1 = current1.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        current1.next = greaterDummy.next;
        return smallerDummy.next;
    }
}