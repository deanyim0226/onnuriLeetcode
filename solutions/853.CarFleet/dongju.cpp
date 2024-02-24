#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int, double>> pos_speed;
        stack<double> fleets;
        for (int i = 0; i < position.size(); ++i) {
            pos_speed.push_back({position[i], (target-position[i]) / (double)speed[i]});
        }

        sort(pos_speed.begin(), pos_speed.end());

        for (int i = 0; i < pos_speed.size(); ++i) {
            double time_needed = pos_speed[i].second;

            while (!fleets.empty() && fleets.top() <= time_needed) {
                fleets.pop();
            }
            fleets.push(time_needed);
        }

        return fleets.size();
    }
};