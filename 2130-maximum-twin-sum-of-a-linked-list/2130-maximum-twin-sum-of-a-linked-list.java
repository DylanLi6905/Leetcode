class Solution {
    public int pairSum(ListNode head) {
        // 1. Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // 3. Compute max twin sum
        int output = 0;
        ListNode p1 = head;
        ListNode p2 = prev;

        while (p2 != null) {
            output = Math.max(output, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }

        return output;
    }
}
