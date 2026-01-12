class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode copy = copyList(head);
        copy = reverse(copy);

        while (head != null && copy != null) {
            if (head.val != copy.val) return false;
            head = head.next;
            copy = copy.next;
        }
        return true;
    }

    private ListNode copyList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head != null) {
            tail.next = new ListNode(head.val);
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
