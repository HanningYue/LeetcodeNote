/**
快慢指针 每次先让快指针走到k个要反转的地方
再写一个iterative翻转range[left，right]的helper reverse方程
翻转，连接listnode和recursive call主方程
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        ListNode newHead = reverse(slow, fast);
        head.next = reverseKGroup(fast, k);
        return newHead;
    }
    private ListNode reverse(ListNode left, ListNode right) {
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