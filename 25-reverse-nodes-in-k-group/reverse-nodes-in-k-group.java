/* Need a reverse helper function, divide the lists in to k-lists, reverse and connect them one-by-one
1. First we let node current reach to k-th place. If current becomes null, it means list length 
   is less than k, return head
2. Record the next node of current k-th place node.断开 Let current next point to null, declare newhead 
   be the reverse function head. 
3. Recursive call, Link the current head with the next k group newHead. head.next = reverseKGroup(next, k);
   Return newHead;
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 1;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return head;
        }
        ListNode nextGroupHead = current.next;
        current.next = null;

        ListNode reverseHead = reverse(head);
        head.next = reverseKGroup(nextGroupHead, k);
        return reverseHead;
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