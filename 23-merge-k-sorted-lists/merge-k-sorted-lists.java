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
        ListNode mergedList = conquer(leftPart, rightPart);
        return mergedList;
    }
    private ListNode conquer(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                current.next = p2;
                p2 = p2.next;
            } else {
                current.next = p1;
                p1 = p1.next;
            }
            current = current.next;
        }
        current.next = p1 == null ? p2 : p1;
        return dummy.next;
    }
}