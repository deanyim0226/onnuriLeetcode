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

    public ListNode tailRecursion(ListNode list1, ListNode list2, ListNode ans){

        if(list1 == null){
            ans.next = list2;
            return ans;
        }

        if(list2 == null){
            ans.next = list1;
            return ans;
        }

        if(list1.val <= list2.val){
            ans.next = list1;
            ans = ans.next;
            tailRecursion(list1.next,list2,ans);
        }else{
            ans.next = list2;
            ans = ans.next;
            tailRecursion(list1,list2.next,ans);
        }

        return null;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
  
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        tailRecursion(list1,list2,ans);
        return dummy.next;
    }
}