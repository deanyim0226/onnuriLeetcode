#include <vector>
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
        vector<int> res;
        vector<TreeNode*> q;
        if (root) q.push_back(root);
        while (!q.empty()) {
            vector<int> level;
            vector<TreeNode*> nq;
            for (int i = 0; i < q.size(); ++i) {
                level.push_back(q[i]->val);
                if (q[i]->left) {
                    nq.push_back(q[i]->left);
                }
                if (q[i]->right) {
                    nq.push_back(q[i]->right);
                }
            }
            q = nq;
            res.push_back(level[level.size()-1]);
        }
        return res;
    }
};