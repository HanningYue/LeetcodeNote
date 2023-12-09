/**
1.先写一个iterative翻转range[left，right]的helper方程
2.recursive call主方程
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        ListNode newHead = reverseRange(head, slow, fast);
        slow.next = reverseKGroup(fast, k);
        return newHead;
    }
    private ListNode reverseRange(ListNode head, ListNode left, ListNode right) {
        ListNode prev = null, current = left;
        while (current != right) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}