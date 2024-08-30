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
            ListNode kth = current;
            for (int i = 0; i < k; i++) {
                if (kth == null) {
                    return head;
                }
                kth = kth.next;
            }

            ListNode tempPrevious = previous, tempCurrent = current;
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (tempPrevious == null) {
                head = previous;
            } else {
                tempPrevious.next = previous;
            }
            previous = tempCurrent;
            tempCurrent.next = current;
        }
        return head;
    }
}