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

     if (!root) return true; 

        if (root->left) {
           
            TreeNode* maxNode = root->left;
            while (maxNode->right) {
                maxNode = maxNode->right;
            }
            
            if (maxNode->val >= root->val) return false;
        }

        
        if (root->right) {
            
            TreeNode* minNode = root->right;
            while (minNode->left) {
                minNode = minNode->left;
            }
            
            if (minNode->val <= root->val) return false;
        }

        
        return isValidBST(root->left) && isValidBST(root->right);
    } 
};