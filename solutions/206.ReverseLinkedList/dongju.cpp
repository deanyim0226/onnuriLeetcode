
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* helper(ListNode* a, ListNode* b) {

        ListNode* nxt = b->next;
        b->next = a;
        if (nxt == nullptr) {
            return b;
        }
        return helper(b, nxt);
    }
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }
        return helper(nullptr, head);
    }
};