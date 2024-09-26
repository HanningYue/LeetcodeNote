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
        ListNode greaterThan = new ListNode(-1);
        ListNode greaterPlaceHolder = greaterThan;

        ListNode smallerThan = new ListNode(-1);
        ListNode smallerPlaceHolder = smallerThan;

        while (head != null) {
            if (head.val < x) {
                smallerThan.next = head;
                smallerThan = smallerThan.next;
            } else {
                greaterThan.next = head;
                greaterThan = greaterThan.next;
            }
            head = head.next;
        }

        smallerThan.next = greaterPlaceHolder.next;
        greaterThan.next = null;
        return smallerPlaceHolder.next;
    }
}