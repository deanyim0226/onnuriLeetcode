/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        auto cur = root;
        std::unordered_map<TreeNode*, TreeNode*> parent_map;
        std::vector<TreeNode*> stack;
        stack.push_back(root);

        while (stack.size() != 0) {
            auto cur = stack.back();
            stack.pop_back();
            if (cur->left != nullptr) {
                stack.push_back(cur->left);
                parent_map[cur->left] = cur;
            }
            if (cur->right != nullptr) {
                stack.push_back(cur->right);
                parent_map[cur->right] = cur;
            }
        }

        std::unordered_map<int, bool> visited;
        cur = p;
        visited[cur->val] = true;
        while (parent_map.find(cur) != parent_map.end()) {
            cur = parent_map[cur];
            visited[cur->val] = true;
        }

        cur = q;
        if (visited.find(cur->val) != visited.end()) {
            return cur;
        }
        while (parent_map.find(cur) != parent_map.end()) {
            cur = parent_map[cur];
            if (visited.find(cur->val) != visited.end()) {
                return cur;
            }
        }
        return nullptr;
    }
};
