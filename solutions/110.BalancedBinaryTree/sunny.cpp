#include <math.h>
#include <algorithm>


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
    bool isBalanced(TreeNode* root) {

        if(root == nullptr){

            return true; 
        }   


        int lh = height(root->left);
        int rh = height(root->right);


        if(abs(lh-rh) <= 1 && isBalanced(root->left) && isBalanced(root->right)){

            return true;
        }



        return false;

    }

   
    int height(TreeNode* root){

        if(root == nullptr){

            return 0;
        }

        int leftheight = height(root->left); 
        int rightheight = height(root->right); 

        return max(leftheight, rightheight)+1; 


        
    }
        
};

