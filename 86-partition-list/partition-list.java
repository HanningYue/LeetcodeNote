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
        ListNode biggerDummy = new ListNode(-1);
        ListNode smaller = smallerDummy;
        ListNode bigger = biggerDummy;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                bigger.next = p;
                bigger = bigger.next;
            } else {
                smaller.next = p;
                smaller = smaller.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        smaller.next = biggerDummy.next;
        return smallerDummy.next;
    }
}