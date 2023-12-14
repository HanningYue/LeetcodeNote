/**
1.先写一个iterative翻转range[left，right]的helper方程
2.recursive call主方程
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode reverseHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return reverseHead;
    }
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null, current = a;
        while (current != b) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}