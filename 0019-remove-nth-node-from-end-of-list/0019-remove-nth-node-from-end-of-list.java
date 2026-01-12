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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Initialize an n space gap between fast and slow
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return head;
    }
}