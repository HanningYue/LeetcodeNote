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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            while (!stack.isEmpty() && current.val > stack.peek().val) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().next = current;
            }
            stack.push(current);
            current = current.next;
        }
        return stack.get(0);
    }
}