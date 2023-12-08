/**
让两个链表相连接
当两个node相等时，返回
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA, currentB = headB;
        while (currentA != currentB) {
            if (currentA == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }
            if (currentB == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }
        return currentA;
    }
}