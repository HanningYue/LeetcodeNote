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
        ListNode head = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        while (!heap.isEmpty()) {
            ListNode currentSmallest = heap.poll();
            head.next = currentSmallest;
            head = head.next;
            if (currentSmallest.next != null) {
                heap.offer(currentSmallest.next);
            }
        }
        return dummy.next;
    }
}