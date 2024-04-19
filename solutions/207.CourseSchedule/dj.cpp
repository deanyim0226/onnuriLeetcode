#include <vector>   
using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> preCnt(numCourses, 0);
        vector<vector<int>> graph(numCourses, vector<int>());
        for (auto cond: prerequisites) {
            int prev = cond[0];
            int pro = cond[1];
            ++preCnt[pro];
            graph[prev].push_back(pro);
        }

        vector<int> q;
        int finished = 0;
        for (int i = 0; i < numCourses; ++i) {
            if (preCnt[i] == 0) {
                q.push_back(i);
            }
        }

        while (!q.empty()) {
            int cur = q.back();
            q.pop_back();
            finished++;
            for (int nxt: graph[cur]) {
                --preCnt[nxt];
                if (preCnt[nxt] == 0) {
                    q.push_back(nxt);
                }
            }
        }

        return finished == numCourses;
    }
};