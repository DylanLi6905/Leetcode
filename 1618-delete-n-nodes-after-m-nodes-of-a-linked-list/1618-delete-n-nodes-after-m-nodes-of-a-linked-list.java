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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode mTemp = head;

        while (mTemp != null) {
            // Skip m - 1 nodes
            for (int i = 1; i < m && mTemp != null; i++) {
                mTemp = mTemp.next;
            }

            if (mTemp == null) break;

            // Start from mTemp and skip n nodes
            ListNode nTemp = mTemp.next;
            for (int j = 0; j < n && nTemp != null; j++) {
                nTemp = nTemp.next;
            }

            // Connect mTemp to the node after the n skipped ones
            mTemp.next = nTemp;
            mTemp = nTemp;
        }

        return head;
    }
}