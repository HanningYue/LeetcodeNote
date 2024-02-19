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
        ListNode dummyOne = new ListNode(0);
        ListNode dummyTwo = new ListNode(0);
        ListNode smaller = dummyOne;
        ListNode bigger = dummyTwo;

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
        smaller.next = dummyTwo.next;
        bigger.next = null;
        return dummyOne.next;
    }
}