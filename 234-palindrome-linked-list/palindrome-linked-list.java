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
    private ListNode frontPointer;
    public boolean recursiveChecking(ListNode backPointer){
        if(backPointer != null){
            if(!recursiveChecking(backPointer.next)){
                return false;
            }
            if(frontPointer.val != backPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursiveChecking(head);
    }
}