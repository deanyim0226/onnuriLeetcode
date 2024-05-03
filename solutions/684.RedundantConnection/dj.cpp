#include <vector>
#include <algorithm>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<unordered_set<int>> graph(edges.size() + 1);
        for (auto edge: edges) {
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);
        }

        for (int i = edges.size() - 1; i >= 0; --i) {
            auto edge = edges[i];
            graph[edge[0]].erase(edge[1]);
            graph[edge[1]].erase(edge[0]);
            if (dfs(graph)) return edge;
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);

        }
        return {};
    }

    bool dfs(vector<unordered_set<int>>& graph) {
        unordered_set<int> visited;
        vector<int> q = {1};
        visited.insert(1);
        while (!q.empty()) {
            int cur = q.back();
            q.pop_back();
            for (int next: graph[cur]) {
                if (visited.count(next) == 0) {
                    visited.insert(next);
                    q.push_back(next);
                }
            }
        }
        return visited.size() == graph.size() - 1;
    }
};