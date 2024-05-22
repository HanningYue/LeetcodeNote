/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode resultHead = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }

        while (!heap.isEmpty()) {
            ListNode current = heap.poll();
            resultHead.next = current;
            resultHead = resultHead.next;

            if (current.next != null) {
                heap.offer(current.next);
            }
        }
        return dummy.next;
    }
}