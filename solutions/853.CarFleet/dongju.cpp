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
        //12 target
        //1  3 1 4 2  speed
        //0  3 5 8 10 pos
        //12 3 7 1 1
        //           6.99 hours passed car_pos2-car_pos3 :::: target
        //12 7 1
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