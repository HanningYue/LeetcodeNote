/**
dummy Node
快慢指针 加上 n--，慢指针走到nth node的前一个 用.next = .next.next 跳过他
1. 先让快指针走n步
2. 再让慢指针走跟快指针同步走，直到快指针走到最后一个node
3. 这是慢指针locate at nth node 我们只需要跳过他的next 即可
Edge Case, 如果n > listnode.length 比如fast在n == 0 之前先变成null，返还original list
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
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}