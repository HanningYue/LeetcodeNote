/**
1. 先使用slow和fast 快慢指针将慢指针走到中间的位置
2. Reverse后半段，慢指针这时是后半段的第一个node. Reverse完成后，previous成为original的最后一个node
3. 用first和second来构建最后的listnode，退出条件是当后半段走到最后的node时(.next != null)
4.  temp = first.next first.next = second first = temp 
    temp = second.next second.next = firstsecond = temp;
*/
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode previous = null;
        ListNode current = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        ListNode first = head;
        ListNode second = previous;
        while (second.next != null) {
            ListNode temp = first.next;
            first.next = second;
            first = temp;
            
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}