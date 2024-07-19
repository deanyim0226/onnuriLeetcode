class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        std::map<int, int> count;
        for (const auto &weight : people) {
            if (count.find(weight) == count.end()) {
                count[weight] = 0;
            }
            count[weight]++;
        }

        std::vector<int> boats;
        int answer = count[limit];
        count[limit] = 0;

        int i = limit - 1;
        while (i > limit / 2) {
            if (count.find(i) != count.end() && count[i] > 0) {
                if (count.find(limit-i) != count.end() && count[limit-i] > 0) {
                    int boat = min(count[i], count[limit-i]);
                    answer += boat;
                    count[i] -= boat;
                    count[limit-i] -= boat;
                }
                while (count[i] > 0) {
                    boats.push_back(i);
                    count[i]--;
                }
            }
            i--;
        }
        if (i == limit - i) {
            if (count.find(i) != count.end()) {
                while (count[i] >= 2) {
                    count[i] -= 2;
                    answer++;
                }
            }
        }

        int boat_idx = 0;
        for (const auto &pair : count) {
            int weight = pair.first;
            int num = pair.second;
            while (num > 0) {
                bool is_full = false;
                while (boat_idx < boats.size()) {
                    if (boats[boat_idx] + weight <= limit) {
                        boats[boat_idx] += weight;
                        num--;
                        boat_idx++;
                        is_full = true;
                        break;
                    } else {
                        boat_idx++;
                    }
                }
                if (!is_full) {
                    if (boat_idx == boats.size()) {
                        boats.push_back(weight);
                        num--;
                    }
                }
            }
        }
        answer += boats.size();
        return answer;
    }
};
