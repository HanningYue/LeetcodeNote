/* Need a reverse helper function, divide the lists in to k-lists, reverse and connect them one-by-one
先让current 走到kth， 先把第一个group reverse （with helper function）
记录current的next， 断开current 和 next
reverse当前的group，declare头node作为reverse后的头node
original的head node 现在是reverse后的最后一个node
让head.next等于之前记录的下一个group （recursion call 当前function， 当前function返回 reverse过后的头node）
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 1;
        while (count < k && current != null) {
            count++;
            current = current.next;
        }
        if (current == null) {
            return head;
        }
        ListNode nextGroupHead = current.next;
        current.next = null;

        ListNode reverseHead = reverse(head); //The kth node after reverse
        head.next = reverseKGroup(nextGroupHead, k); //Head is still original head, right now at the kth place
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