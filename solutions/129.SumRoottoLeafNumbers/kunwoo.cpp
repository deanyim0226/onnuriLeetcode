/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        std::vector<TreeNode *> path;
        std::unordered_map<TreeNode *, bool> left_child;
        auto cur_node = root;
        int answer = 0;

        path.push_back(cur_node);
        while (path.size() != 0) {
            if (cur_node->left != nullptr) {
                left_child[cur_node] = true;
                cur_node = cur_node->left;
                path.push_back(cur_node);
            } else if (cur_node->right != nullptr) {
                left_child[cur_node] = false;
                cur_node = cur_node->right;
                path.push_back(cur_node);
            } else {
                unsigned int i = 1;
                for (auto riter = path.rbegin(); riter != path.rend(); riter++) { 
                    answer += (*riter)->val * i;
                    i *= 10;
                } 

                while (true) {
                    path.pop_back();
                    left_child.erase(cur_node);

                    if (path.size() == 0) {
                        break;
                    }
                    cur_node = path.back();

                    if (left_child[cur_node] == true && cur_node->right != nullptr) {
                        left_child[cur_node] = false;
                        cur_node = cur_node->right;
                        path.push_back(cur_node);
                        break;
                    }
                }
            }
        }
        return answer;
    }
};
