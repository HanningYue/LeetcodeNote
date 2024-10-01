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
        ListNode current = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        while (!heap.isEmpty()) {
            ListNode currentSmallest = heap.poll();
            if (currentSmallest.next != null) {
                heap.offer(currentSmallest.next);
            }
            current.next = currentSmallest;
            current = current.next;
        }
        return dummy.next;
    }
}