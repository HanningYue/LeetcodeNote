/**
快慢指针 加上 n--，慢指针走到nth node的前一个 用.next = .next.next 跳过他
1. 先让快指针走n步
2. 
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head;
        }
        
        ListNode slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}