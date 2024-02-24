#include <vector>
using namespace std;

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> decTemp;
        vector<int> res(temperatures.size());

        for(int i=0; i<temperatures.size(); i++) {
            while(!decTemp.empty() && temperatures[decTemp.back()] < temperatures[i]) {
                res[decTemp.back()] = i - decTemp.back();
                decTemp.pop_back();
            }
            decTemp.push_back(i);
        }

        return res;
    }
};