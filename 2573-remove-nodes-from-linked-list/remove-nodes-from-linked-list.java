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
    public ListNode removeNodes(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode next = removeNodes(head.next); //*recursion helps to traverse a linked list backwards
        if(next.val > head.val){ 
            return next; //delete condition met, return the larger
        }
        else{
            head.next = next; //else we connect nodes up
            return head;
        }
        //at the end head will be the largest
    }
}