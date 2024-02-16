#include <vector>
using namespace std;
class Solution {
public:
    // leftmost insertion index
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // find leftmost insertion
        int row_lo = 0;
        int row_hi = matrix.size();
        while (row_lo < row_hi) {
            int mid = row_lo + (row_hi - row_lo)/2;
            if (matrix[mid][0] > target) {
                row_hi = mid;
            } else {
                row_lo = mid + 1;
            }
        }
        if (row_lo == 0) return false;
        int row = row_lo - 1;
        int col_lo = 0;
        int col_hi = matrix[0].size();
        while (col_lo < col_hi) {
            int mid = col_lo + (col_hi - col_lo)/2;
            if (matrix[row][mid] > target) {
                col_hi = mid;
            } else {
                col_lo = mid + 1;
            }
        }
        return col_lo > 0 && matrix[row][col_lo - 1] == target;
    }
};