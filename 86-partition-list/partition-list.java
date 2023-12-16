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
        ListNode biggerDummy = new ListNode(-1);
        ListNode smallerDummy = new ListNode(-1);
        ListNode bigger = biggerDummy;
        ListNode smaller = smallerDummy;
        
        ListNode current = head;
        while (current != null) {
            if (current.val >= x) {
                bigger.next = current;
                bigger = bigger.next;
            } else if (current.val < x) {
                smaller.next = current;
                smaller = smaller.next;
            }
            ListNode temp = current.next;
            current.next = null;
            current = temp;
        }
        smaller.next = biggerDummy.next;
        return smallerDummy.next;
    }
}