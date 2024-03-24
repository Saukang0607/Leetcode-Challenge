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
    public void reorderList(ListNode head) {
        if(head.next == null ||head.next.next == null){
            return ;
        }

        int i = 0;
        ListNode h = head; //make a copy to avoid changing head
        while(h!=null){
            i++;
            h = h.next;
        }
        outHeadToOutTail(head, i);
    }

    public ListNode outHeadToOutTail(ListNode head, int length){
        if(length == 1){
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if(length == 2){
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }

        ListNode tail = outHeadToOutTail(head.next, length-2);
        ListNode innerHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = innerHead;
        return outTail;
    }
}