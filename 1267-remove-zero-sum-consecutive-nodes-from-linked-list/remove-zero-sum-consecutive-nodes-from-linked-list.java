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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        HashMap <Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        for(ListNode cur = dummy; cur != null; cur = cur.next){
            sum += cur.val;
            map.put(sum, cur); //overwrite previous one
        }

        sum = 0;
        for(ListNode cur = dummy; cur != null; cur = cur.next){
            sum += cur.val;
            cur.next = map.get(sum).next;
        }

        return dummy.next;
    }
}