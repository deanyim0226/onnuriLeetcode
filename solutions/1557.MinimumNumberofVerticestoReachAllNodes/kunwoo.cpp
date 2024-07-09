class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        std::vector<bool> has_incoming_edge(n, false);

        for (const auto &edge : edges) {
            has_incoming_edge[edge[1]] = true;
        }

        std::vector<int> answer;
        for (int i = 0; i < n ; i++) {
            if (!has_incoming_edge[i]) {
                answer.push_back(i);
            }
        }
        return answer;
    }
};
