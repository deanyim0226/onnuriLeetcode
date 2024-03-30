#include <algorithm>
using namespace std;
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
 
class Solution {
public:
    int goodNodes(TreeNode* root) {
        return helper(root, root->val);
    }

    int helper(TreeNode* node, int prev) {
        int localCnt = 0;
        if (node == nullptr) return 0;
        if (prev <= node->val) {
            ++localCnt;
        }
        localCnt += helper(node->left, max(prev, node->val)) + helper(node->right, max(prev, node->val));
        return localCnt;
    }
};