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
        ListNode smaller = dummyOne; 
        ListNode dummyTwo = new ListNode(0);
        ListNode greater = dummyTwo;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else if (head.val >= x) {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        smaller.next = dummyTwo.next;
        greater.next = null;
        return dummyOne.next;
    }
}