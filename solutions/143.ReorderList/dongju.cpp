#include <deque>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {
        deque<ListNode*> dq;
        while (head != nullptr) {
            dq.push_back(head);
            head = head->next;
        }
        ListNode* cur = dq.front();

        int sz = dq.size();
        for (int i = 0; i < sz / 2; ++i) {
            dq.pop_front();
        }
        if (sz % 2 == 1) dq.pop_front();

        while (!dq.empty()) {
            ListNode* last = dq.back();
            ListNode* nxt = cur->next;
            cur->next = last;
            last->next = nxt;
            cur = nxt;
            dq.pop_back();
        }
        cur->next = nullptr;
        if (sz % 2 == 0) {
            cur = nullptr;
        }
    }
};