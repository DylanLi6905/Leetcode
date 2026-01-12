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
    public int getDecimalValue(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        //Prev is now the head of the reversed binary
        int output = 0;
        int bit = 0;
        while(prev != null){
            if(prev.val == 1){
                output += (int) Math.pow(2, bit);
            }
            bit++;
            prev = prev.next;
        }
        return output;
    }
}