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
        ListNode biggerDummy = new ListNode(0);
        ListNode bigger = biggerDummy;

        ListNode smallerDummy = new ListNode(0);
        ListNode smaller = smallerDummy;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else if (head.val >= x) {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        smaller.next = biggerDummy.next;
        bigger.next = null;
        return smallerDummy.next;
    }
}