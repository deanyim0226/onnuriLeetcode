#include <vector>
using namespace std;

class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};


class Solution {
public:
    Node* cloneGraph(Node* node) {
        vector<Node*> list(101);
        return cloneHelper(node, list);
    }
    Node* cloneHelper(Node* node, vector<Node*>& nodelist) {
        if (node == nullptr) return nullptr;
        if (nodelist[node->val]) {
            return nodelist[node->val];
        }
        Node * newNode = new Node(node->val);
        nodelist[node->val] = newNode;

        for (int i = 0; i < node->neighbors.size(); ++i) {
            newNode->neighbors.push_back(cloneHelper(node->neighbors[i], nodelist));
        }
        
        return newNode;
    }
};