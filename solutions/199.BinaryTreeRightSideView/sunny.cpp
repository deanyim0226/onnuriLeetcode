#include <vector>
#include <queue>

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
    vector<int> rightSideView(TreeNode* root) {

        vector<int> result;
        if(root == nullptr){

            return result;
        }

        queue<TreeNode*> r;
        r.push(root);

        while(!r.empty()){

            int size = r.size();
            TreeNode* right = nullptr;

            for(int i=0; i < size; ++i){

                TreeNode* node = r.front();
                r.pop();

                right = node;

                if(node->left){

                    r.push(node->left);
                
                }

                if(node->right){

                    r.push(node->right);
                }

            }

             result.push_back(right->val);
        
        }

         return result;
            
    }

};