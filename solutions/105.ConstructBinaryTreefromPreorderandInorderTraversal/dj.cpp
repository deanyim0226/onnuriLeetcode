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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return helper(preorder, inorder, 0, preorder.size(), 0, inorder.size());
    }

    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int prelo, int prehi, int inlo, int inhi) {
        if (prelo >= prehi) return nullptr;
        TreeNode* cur = new TreeNode(preorder[prelo]);
        int inorderMiddle = 0;
        for (int i = 0; i < inorder.size(); ++i) {
            if (inorder[i] == preorder[prelo]) {
                inorderMiddle = i;
                break;
            }
        }
        int sizeLeftTree = inorderMiddle - inlo;
        cur->left = helper(preorder, inorder, prelo + 1, prelo + 1 + sizeLeftTree, inlo, inlo + sizeLeftTree);
        cur->right = helper(preorder, inorder, prelo + 1 + sizeLeftTree, prehi, inorderMiddle + 1, inhi);

        return cur;
    }
};