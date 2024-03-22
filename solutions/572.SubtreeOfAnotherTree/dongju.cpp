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
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if (root == nullptr || subRoot == nullptr) {
            return root == subRoot;
        }

        bool local = recursiveHelper(root, subRoot);
        if (local) return true;

        return isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
    bool recursiveHelper(TreeNode* root, TreeNode* sub) {
        if (root == nullptr || sub == nullptr) {
            return root == sub;
        }

        if (root->val == sub->val) {
            bool local = recursiveHelper(root->left, sub->left) && recursiveHelper(root->right, sub->right);
            if (local) return true;
        }
        return false;
    }
};