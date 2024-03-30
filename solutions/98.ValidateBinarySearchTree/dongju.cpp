#include <vector>
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
    bool isValidBST(TreeNode* root) {
        vector<int> inorderTraversal;
        inorderHelper(root, inorderTraversal);
        for (int i = 0; i < inorderTraversal.size() - 1; ++i) {
            if (inorderTraversal.at(i) >= inorderTraversal.at(i + 1)) return false;
        }
        return true;
    }
    void inorderHelper(TreeNode* root, vector<int>& arr) {
        if (root != nullptr) {
            inorderHelper(root->left, arr);
            arr.push_back(root->val);
            inorderHelper(root->right, arr);
        }
    }
};