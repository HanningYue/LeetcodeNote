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
        return merge(leftPart, rightPart);
    }
    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                current.next = p;
                p = p.next;
            } else {
                current.next = q;
                q = q.next;
            }
            current = current.next;
        }
        current.next = (p == null ? q : p);
        return dummy.next;
    }
}