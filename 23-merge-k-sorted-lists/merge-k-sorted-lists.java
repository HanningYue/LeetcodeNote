/**
Divide and conquer
1. Divide the lists array into sub-array until each array contain only one list
    Base case is when low == high, return the smallest element in each sub-array
2. Compare the ListNode of each array and merge them together
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return lists[high];
        }
        int mid = low + (high - low) / 2;
        ListNode left = divide(lists, low, mid);
        ListNode right = divide(lists, mid + 1, high);
        return merge(left, right);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                current.next = n2;
                n2 = n2.next;
            } else {
                current.next = n1;
                n1 = n1.next;
            }
            current = current.next;
        }
        current.next = n1 == null ? n2 : n1;
        return dummy.next;
    }
}