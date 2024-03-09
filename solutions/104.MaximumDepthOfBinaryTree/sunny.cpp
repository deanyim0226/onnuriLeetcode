#include <algorithm>
#include <iostream>

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
    int maxDepth(TreeNode* root) {

      if(root == nullptr){

          return 0;

      }

      else{

        int leftroot = maxDepth(root ->left);
        int rightroot = maxDepth(root ->right);

        int result = std::max(leftroot, rightroot);

        return 1+result;
       
     }

    }
};