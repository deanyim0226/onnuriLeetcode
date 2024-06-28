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

    public ListNode mergeSort(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeSort(left,right);
    }

    public ListNode getMid(ListNode head){
        ListNode midPrev = null;

        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count += 1;
            temp = temp.next;
        }

        temp = head;
        int stop = count/ 2;

        while(stop != 0){
            stop -= 1;
            midPrev = temp;
            temp = temp.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}