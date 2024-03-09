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
    int diameterOfBinaryTree(TreeNode* root) {
        int res = 0;
        helper(root, &res);
        return res;
    }
    int helper(TreeNode* root, int* val) {
        if (root == nullptr) return 0;
        int left = helper(root->left, val);
        int right = helper(root->right, val);
        *val = std::max(*val, left + right);

        return 1 + std::max(left, right);
    }
};