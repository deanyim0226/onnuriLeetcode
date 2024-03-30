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

    int helper(TreeNode* root, int max){

        if(root==nullptr){

            return 0;
        }

        int count = 0;

        if(root->val >= max){

            ++count;
            max = root->val;
        }

        count+=helper(root->left, max);
        count+=helper(root->right, max);

        return count;
    }
};