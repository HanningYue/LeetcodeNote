class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head, previousNodeOfSublist = dummy;
        while (current != null) {
            ListNode lastNodeOfSublist = current;
            int count = 0;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            if (count == k) {
                ListNode reverseHead = reverse(lastNodeOfSublist, k);
                previousNodeOfSublist.next = reverseHead;
                previousNodeOfSublist = lastNodeOfSublist;
            } else {
                previousNodeOfSublist.next = lastNodeOfSublist;
                break;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head, int k) {
        ListNode current = head, previous = null;
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