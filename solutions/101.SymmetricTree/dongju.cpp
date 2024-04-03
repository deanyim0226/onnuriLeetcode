

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
    bool isSymmetric(TreeNode* root) {
        return recursive(root->left, root->right);
    //     queue<TreeNode*> left;
    //     queue<TreeNode*> right;
    //     if (root->left) left.push(root->left);
    //     if (root->right) right.push(root->right);

    //     if (!left.empty() && !right.empty() && left.front()->val != right.front()->val) return false;
    //     while (!left.empty() && !right.empty()) {
    //         queue<TreeNode*> nextleft;
    //         queue<TreeNode*> nextright;
    //         while (!left.empty() && !right.empty()) {
    //             TreeNode* curleft = left.front();
    //             TreeNode* curright = right.front();
    //             if (curleft->left && curright->right) {
    //                 if (curleft->left->val != curright->right->val) {
    //                     return false;
    //                 }
    //                 nextleft.push(curleft->left);
    //                 nextright.push(curright->right);
    //             } else if (curleft->left || curright->right) {
    //                 return false;
    //             }

    //             if (curleft->right && curright->left) {
    //                 if (curleft->right->val != curright->left->val) {
    //                     return false;
    //                 }
    //                 nextleft.push(curleft->right);
    //                 nextright.push(curright->left);
    //             } else if (curleft->right || curright->left) {
    //                 return false;
    //             }
    //             left.pop();
    //             right.pop();
    //         }
            
    //         left = nextleft;
    //         right = nextright;
    //     }
    //     return left.empty() && right.empty();
    }
    bool recursive(TreeNode* left, TreeNode* right) {
        if (left && right) {
            return left->val == right->val && recursive(left->right, right->left) && recursive(left->left, right->right);
        }
        return left == nullptr && right == nullptr;
    }
};