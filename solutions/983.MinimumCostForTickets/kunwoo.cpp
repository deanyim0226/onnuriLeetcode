class Solution {
private:
    int dp_[365];
    std::vector<int> days_;
    std::vector<int> costs_;

public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        memset(dp_, 0, 365);
        days_ = days;
        costs_ = costs;
        return mincostTicketsInternal(0);
    }

private:
    int mincostTicketsInternal(int idx) {
        if (dp_[idx] != 0) {
            return dp_[idx];
        }

        if (idx == days_.size() - 1) {
            dp_[idx] = min(min(costs_[0], costs_[1]), costs_[2]);
            return dp_[idx];
        } 

        int first_day = days_[idx];
        int last_day = days_.back();

        if (last_day - first_day + 1 < 7) {
            dp_[idx] = min(min(costs_[0] + mincostTicketsInternal(idx + 1),
                           costs_[1]), costs_[2]);
        } else if (last_day - first_day + 1 < 30) {
            int i; 
            for (i = idx + 1; i < days_.size(); i++) {
                if (days_[i] >= first_day + 7) {
                    break;
                }
            }
            dp_[idx] = min(min(costs_[0] + mincostTicketsInternal(idx + 1),
                        costs_[1] + (i < days_.size() ? mincostTicketsInternal(i) : 0)),
                        costs_[2]);
        } else {
            int i; 
            for (i = idx + 1; i < days_.size(); i++) {
                if (days_[i] >= first_day + 7) {
                    break;
                }
            }
            int j;
            for (j = i + 1; j < days_.size(); j++) {
                if (days_[j] >= first_day + 30) {
                    break;
                }
            }
            dp_[idx] = min(min(costs_[0] + mincostTicketsInternal(idx + 1),
                          costs_[1] + (i < days_.size() ? mincostTicketsInternal(i) : 0)),
                          costs_[2] + (j < days_.size() ? mincostTicketsInternal(j) : 0));
        }
        return dp_[idx];
    }
};
