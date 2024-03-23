 struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
 
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {

      ListNode *node = head;
      ListNode *nextnode = NULL;

      if(node == nullptr){

        return nullptr;

      }

      while(node->next != nullptr){

        if(node->val == node->next->val){

            nextnode = node->next->next;
            node->next = nextnode;
        }
        else{

            node = node->next;
        }

      }


      return head;
        
    }
};
