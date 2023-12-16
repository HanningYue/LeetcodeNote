/**
快慢指针，走一半
翻转后半段 和前半段对比
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode reverseHalf = reverse(slow);
        while (reverseHalf != null) {
            if (head.val != reverseHalf.val) {
                return false;
            }
            reverseHalf = reverseHalf.next;
            head = head.next;
        }        
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}