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
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previousOfSublist = dummy;
        ListNode current = head;
        while (current != null) {
            ListNode lastOfSublist = current;
            int count = 0;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }
            
            if (count == k) {
                ListNode reverseHead = reverse(lastOfSublist, k);
                previousOfSublist.next = reverseHead;
                previousOfSublist = lastOfSublist;
            } else {
                previousOfSublist.next = lastOfSublist ;
                break;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head, int k) {
        ListNode current = head, previous = null;
        while (k > 0 && current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            k--;
        }
        return previous;
    }
}