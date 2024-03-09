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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;

        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        while(curr != null){

            curr = curr.next;
            size += 1;
        }

        curr = head;

        int count = 0;
        ListNode next = null;

        while(curr != null){

            if(size - n == count){
                next = curr.next;
                break;
            }

            count += 1;

            ans.next = curr;
            ans = ans.next;

            curr = curr.next;
        }

        ans.next = next;

        return dummy.next;
    }
}