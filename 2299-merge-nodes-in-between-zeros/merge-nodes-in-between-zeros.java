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
    public ListNode mergeNodes(ListNode head) {
        ListNode fast = head.next, slow = head;
        int sum = 0;
        while(fast.next != null){ //while not last node
            if(fast.val == 0){
                slow.val = sum;
                slow = slow.next;
                sum = 0;
            }
            else{
                sum += fast.val;
            }
            fast = fast.next;
        }
        if(fast.val == 0){
            slow.val = sum;
            slow.next = null;
        }
        return head;
    }
}