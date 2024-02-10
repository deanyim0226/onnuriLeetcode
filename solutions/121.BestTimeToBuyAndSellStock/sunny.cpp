#include <iostream>
#include <vector>


using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {

      int n = prices.size();

      int minprice = prices[0];  

      int maxprof = 0;

      if(n<=1){

          return 0;
      }


      for(int i=1; i<n; i++){

          if(prices[i] < minprice){

              minprice = prices[i];
          }

          int currentprof = prices[i]-minprice;


          if(currentprof > maxprof){

              maxprof = currentprof;
          }

      }


      return maxprof;

    }
};