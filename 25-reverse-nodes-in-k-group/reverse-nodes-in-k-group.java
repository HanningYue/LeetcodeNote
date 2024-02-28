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
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode check = current;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    return head;
                }
                check = check.next;
            }

            ListNode previousOfList = previous, endOfList = current;
            for (int i = 0; i < k && current != null; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (previousOfList == null) {
                head = previous;
            } else {
                previousOfList.next = previous;
            }
            endOfList.next = current;
            previous = endOfList;
        }
        return head;
    }
}