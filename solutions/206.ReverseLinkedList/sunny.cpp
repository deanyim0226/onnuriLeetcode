



 struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };
 
class Solution {
public:

    ListNode* helper(ListNode* current, ListNode* prev){

        if(current == nullptr){

            return prev;
        }

        ListNode* nextNode = current -> next;
        current -> next = prev;

        return helper(nextNode, current);

    }
    

    ListNode* reverseList(ListNode* head) {
        
         if (head == nullptr) {
            return nullptr;
        }

        return helper(head, nullptr);
        
       
      
    }
};