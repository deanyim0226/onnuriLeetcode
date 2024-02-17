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

    public ListNode tailRecursion(ListNode head, ListNode reversed){

        if(head == null){
            return reversed;
        }

        ListNode next = head.next;
        head.next = reversed;
        reversed = head;
        head = next;
        
        return tailRecursion(next, reversed);
    }

    public ListNode recursion(ListNode curr){

        if(curr.next == null){
            return curr;
        }       
        /*
        //prev = null
        //head = 5->null
        -------------------
        //head = 4->5->null
        //head = 3->4->5->null
        //head = 2->3->4->5->null
        //head = 1->2->3->4->5->null
        keep the head as it is and change the pointers so that we can return the head. 
        */
        ListNode head = recursion(curr.next);
    
        curr.next.next = curr;
        curr.next = null;

        return head;

    }

    public ListNode reverseList(ListNode head) {
        //return tailRecursion(head,null);    
        if(head == null){
            return null;
        }
       
        return recursion(head);

    }
}