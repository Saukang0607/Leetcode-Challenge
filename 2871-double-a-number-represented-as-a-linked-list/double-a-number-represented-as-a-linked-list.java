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
        if(carry(head)){ //still have the carry hence appending a new head with value 1
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public boolean carry(ListNode curr){
        boolean plusOne;
        if(curr.next != null){
            plusOne = carry(curr.next); //recursion is used to traverse the list backwards
        }
        else{ //base case: last node
            plusOne = (curr.val * 2 > 9) ? true : false; 
            curr.val = (curr.val * 2) % 10;
            return plusOne;
        }

        boolean newPlusOne = (curr.val * 2 > 9) ? true : false; //doesn't matter got carry or not
        curr.val = (curr.val * 2) % 10;
        if(plusOne){
            curr.val += 1;
        }
        return newPlusOne;
    }
}