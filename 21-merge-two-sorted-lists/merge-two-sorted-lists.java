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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }
    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                current.next = p;
                p = p.next;
            } else if (p.val >= q.val) {
                current.next = q;
                q = q.next;
            }
            current = current.next;
        }
        if (p != null) {
            current.next = p;
        } else if (q != null) {
            current.next = q;
        }
        return dummy.next;
    }
}