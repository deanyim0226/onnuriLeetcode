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
    int kthSmallest(TreeNode* root, int k) {
        vector<int> increasing;
        inorder(root, increasing);
        return increasing[k-1];
    }
    void inorder(TreeNode* root, vector<int>& traversal) {
        if (root) {
            inorder(root->left, traversal);
            traversal.push_back(root->val);
            inorder(root->right, traversal);
        }
    }
};