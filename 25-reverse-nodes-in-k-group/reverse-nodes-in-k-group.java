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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode previous = null, start = head;
        while (start != null) {
            ListNode check = start;
            for (int i = 0; i < k - 1; i++) {
                check = check.next;
                if (check == null) {
                    return head;
                }
            }

            ListNode previousOfList = previous;
            ListNode endOfList = start;
            for (int i = 0; i < k; i++) {
                ListNode next = start.next;
                start.next = previous;
                previous= start;
                start = next;
            }

            if (previousOfList == null) {
                head = previous;
            } else {
                previousOfList.next = previous;
            }
            endOfList.next = start;
            previous = endOfList;
        }
        return head;
    }
}