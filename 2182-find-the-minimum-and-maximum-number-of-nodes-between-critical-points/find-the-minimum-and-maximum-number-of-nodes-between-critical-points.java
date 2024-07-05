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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {Integer.MAX_VALUE, -1};
        int prev = head.val, prev_location = -1, first_location = -1, idx = -1;
        boolean is_first = true;
        ListNode curr = head.next;
        while(curr.next != null){ 
            idx++; 
            if((curr.val < prev && curr.val < curr.next.val) ||
            (curr.val > prev && curr.val > curr.next.val)) { //critical point
                if(prev_location != -1){
                    ans[0] = Math.min(ans[0], idx - prev_location);
                    ans[1] = Math.max(ans[1], idx - first_location);
                }

                if(is_first){
                    first_location = idx;
                    is_first = false;
                }
                
                prev_location = idx; 
            }
            prev = curr.val;
            curr = curr.next;
        }

        return ans[1] == -1 ? new int[] {-1, -1} : ans;
    }
}