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
            int count = 0;
            for (int i = 0; i < k - 1; i++) {
                check = check.next;
                if (check == null) {
                    return head;
                }
                count++;
            }

            ListNode startOfSublist = previous;
            ListNode endOfSublist = current;
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (startOfSublist == null) {
                head = previous;
            } else {
                startOfSublist.next = previous;
            }
            endOfSublist.next = current;
            previous = endOfSublist;
        }
        return head;
    }
}
/**
        if (head == null || head.next == null) {
            return head;
        }
        ListNode kth = head, start = head;
        for (int i = 0; i < k; i++) {
            if (kth == null) {
                return head;
            }
            kth = kth.next;
        }
        ListNode reversedHead = reverseRange(start, kth);
        start.next = reverseKGroup(kth, k);
        return reversedHead;
    }

    private ListNode reverseRange(ListNode left, ListNode right) {
        ListNode previous = null, current = left;
        while (current != right) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
*/