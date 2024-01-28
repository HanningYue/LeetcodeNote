/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.ne-xt = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = null;

        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(slow);
        return merge(leftNode, rightNode);
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
        if (p != null) {
            current.next = p;
        }
        if (q != null) {
            current.next = q;
        }
        return dummy.next;
    } 
}