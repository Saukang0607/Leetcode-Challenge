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
    public ListNode doubleIt(ListNode head) {
        if(carry(head)){ //still have the carry
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public boolean carry(ListNode curr){
        boolean plusOne;
        if(curr.next != null){
            plusOne = carry(curr.next);
        }
        else{ //base case
            plusOne = (curr.val * 2 > 9) ? true : false; 
            curr.val = (curr.val * 2) % 10;
            return plusOne;
        }

        boolean newPlusOne = (curr.val * 2 > 9) ? true : false;
        if(plusOne){
            curr.val = (curr.val * 2) % 10 + 1;
        }
        else{
            curr.val = (curr.val * 2) % 10;
        }

        return newPlusOne;
    }
}