class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode previous = null, current = head;
        while (current != null) {
            // Check if there are at least k nodes left to reverse
            ListNode check = current;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }
            if (count < k) {
                // Fewer than k nodes remaining, do not reverse
                break;
            }

            ListNode previousOfSublist = previous;
            ListNode endOfSublist = current;
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            
            if (previousOfSublist != null) {
                previousOfSublist.next = previous;
            } else {
                head = previous;
            }
            endOfSublist.next = current;
            if (current == null) {
                break;
            }
            previous = endOfSublist;
        }
        return head;
    }
}
