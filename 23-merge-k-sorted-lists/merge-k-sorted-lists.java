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
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode p, ListNode q) {
                return p.val - q.val;
            }
        });
        
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode currentSmallest = minHeap.poll();
            if (currentSmallest.next != null) {
                minHeap.offer(currentSmallest.next);
            }

            current.next = currentSmallest;
            current = current.next;
        }
        return dummy.next;
    }
}