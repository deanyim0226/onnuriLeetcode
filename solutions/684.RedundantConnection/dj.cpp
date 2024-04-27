#include <vector>
#include <algorithm>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<vector<int>> graph(edges.size() + 1);
        for (auto edge: edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }

        for (int i = edges.size() - 1; i >= 0; --i) {
            graph[edges[i][0]].erase(remove(graph[edges[i][0]].begin(), graph[edges[i][0]].end(), edges[i][1]), graph[edges[i][0]].end());
            graph[edges[i][1]].erase(remove(graph[edges[i][1]].begin(), graph[edges[i][1]].end(), edges[i][0]), graph[edges[i][1]].end());
            if (dfs(graph)) return edges[i];
            graph[edges[i][0]].push_back(edges[i][1]);
            graph[edges[i][1]].push_back(edges[i][0]);

        }
        return {};
    }

    bool dfs(vector<vector<int>>& graph) {
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