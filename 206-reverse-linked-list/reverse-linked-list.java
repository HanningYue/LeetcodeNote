/**
1. We need to use two ListNodes, prev and next to record the head ListNode pointer
2. we need to change the head pointer next reference to null, the prev reference to next
3. Repeat this 
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}