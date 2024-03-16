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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        int sum = 0;
        int carry = 0;
        while(l1 != null && l2 != null){
            
            sum = l1.val + l2.val;

            if(carry != 0){
                sum += 1;
                carry = 0;
            }

            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }

            ans.next = new ListNode(sum);
            ans = ans.next;

            l1 = l1.next;
            l2 = l2.next;
        }

   
        if(l1 != null){
            while(l1 != null){
                
                if(carry != 0){
                    l1.val += carry;
                    carry = 0;    
                }

                if(l1.val >= 10){
                    l1.val = l1.val % 10;
                    carry += 1;
                }
                ans.next = new ListNode(l1.val);
                ans = ans.next;

                l1 = l1.next;
            }
        }
            
        if(l2 != null){
            while(l2 != null){
                
                if(carry != 0){
                    l2.val += carry;
                    carry = 0;    
                }

                if(l2.val >= 10){
                    l2.val = l2.val % 10;
                    carry += 1;
                }
                ans.next = new ListNode(l2.val);
                ans = ans.next;

                l2 = l2.next;
            }
        }
            
        if(carry > 0){
            ans.next = new ListNode(carry);
        }

        return dummy.next;
    }
}