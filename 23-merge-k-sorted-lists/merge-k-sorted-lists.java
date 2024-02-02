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
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }
    private ListNode divide(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftPart = divide(lists, left, mid);
        ListNode rightPart = divide(lists, mid + 1, right);
        ListNode merged = merge(lists, leftPart, rightPart);
        return merged;
    }
    private ListNode merge(ListNode[] lists, ListNode p, ListNode q) {
        ListNode dummy = new ListNode(-1);
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