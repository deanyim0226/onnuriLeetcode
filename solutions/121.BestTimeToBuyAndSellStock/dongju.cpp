#include <vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minbuy = prices[0];
        int res = 0;
        for (int price: prices) {
            res = max(res, price - minbuy);
            minbuy = min(minbuy, price);
        }
        return res;
    }
};