/* Need a reverse helper function, divide the lists in to k-lists, reverse and connect them one-by-one
1. First we let node current reach to k-th place. If current becomes null, it means list length 
   is less than k, return head
2. Record the next node of current k-th place node. Let current next point to null, declare newhead be the 
   reverse function head. 
3. 
   
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head;
        }

        ListNode next = current.next;
        current.next = null;
        
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(next, k);
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}