/**

*/
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
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