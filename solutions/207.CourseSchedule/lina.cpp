class Solution {
public:

    bool isCyclic(vector<vector<int>> & adj, vector<int> & visited, int curr)
    {
        if(visited[curr] ==2)
            return true;

        visited[curr] = 2;
        for(int i = 0; i <adj[curr].size(); ++i)
            if(visited[adj[curr][i]] != 1)
                if(isCyclic(adj,visited, adj[curr][i]))
                    return true;
        
        visited[curr] = 1;
        return false;
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

        // [[1,0],[1,2],[0,1]]

        // adj = [[0,2],[]]
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        cout.tie(NULL);
        
        vector<vector<int>> adj(numCourses);

        // adjacency matrix (directed graph)
        for(int i = 0; i < prerequisites.size(); ++i)
        {
            adj[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }

        vector<int> visited(numCourses, 0);

        for(int i = 0; i < numCourses; i++)
        {
            if(visited[i]==0)
                if(isCyclic(adj, visited, i))
                    return false;
        }

        return true;
    }


};