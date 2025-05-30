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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode output = new ListNode(0);
        ListNode prev = output;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                prev.next = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }
        if(list2 == null){
            prev.next = list1;
        } else {
            prev.next = list2;
        }
        return output.next;
    }
}