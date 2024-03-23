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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        ans.next = head;
        ans = ans.next;

        ListNode curr = head.next;

        while(curr != null){
            
            if(ans.val != curr.val){
                ans.next= curr;
                ans = ans.next;
            }

            curr = curr.next;
        }

        ans.next = null;
   
        return dummy.next;
    }
}