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

    public ListNode reverse(ListNode head, ListNode reversed){

        if(head == null){
            return reversed;
        }

        ListNode next = head.next;
        head.next = reversed;
        reversed = head;
        head = next;

        return reverse(head,reversed);

    }
    public void reorderList(ListNode head) {

        ListNode curr = head;
        ListNode reversed = null; 
      
        int listSize = 0;
        while(curr != null){
            listSize += 1;
            curr = curr.next;
        }
        curr = head;
        int count = 0;

        while(curr != null){
            
            if(count == listSize/2){
                reversed = reverse(curr, null);
                break;
            }
            count += 1;
            curr = curr.next;
        }
        ListNode stopNode = curr;
        curr = head;

        while(reversed.next != null){
            ListNode currNext = curr.next;
            curr.next = reversed;

            ListNode revNext = reversed.next;
            reversed.next = currNext;

            reversed = revNext;
            curr = currNext;
        }

    }
}