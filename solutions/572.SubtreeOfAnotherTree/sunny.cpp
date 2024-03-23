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

        if(root == nullptr){

            return false;
        }



        return isEqual(root, subRoot) || isSubtree(root->right, subRoot) || isSubtree(root->left, subRoot);

        
    }


    bool isEqual(TreeNode* root, TreeNode* subRoot){

        if(root == nullptr && subRoot == nullptr){

            return true;
        }

        if(root == nullptr || subRoot == nullptr){

            return false;
        }

        
        if(root->val != subRoot->val){

            return false;

        }

        bool l = isEqual(root->left, subRoot->left);
        bool r = isEqual(root->right, subRoot->right);


        return l && r;
    }

    
};