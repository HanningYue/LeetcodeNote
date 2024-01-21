class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previousBeforeSublist = dummy, current = head;

        while (current != null) {
            ListNode lastNodeOfSubList = current;
            int count = 0;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            if (count == k) {
                // Reverse k nodes
                ListNode reversedHead = reverse(lastNodeOfSubList, k);
                previousBeforeSublist.next = reversedHead;
                previousBeforeSublist = lastNodeOfSubList;
            } else {
                // If there are fewer than k nodes left, do not reverse them
                previousBeforeSublist.next = lastNodeOfSubList;
                break;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode previous = null, current = head;
        while (k > 0 && current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            k--;
        }
        return previous;
    }
}
