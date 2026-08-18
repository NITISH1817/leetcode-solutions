class Solution {
    public ListNode deleteDuplicates(ListNode h) {
        for (ListNode c = h; c != null && c.next != null;)
            if (c.val == c.next.val) c.next = c.next.next;
            else c = c.next;
        return h;
    }
}
