class Solution {
public:
    string reorganizeString(string s) {
        std::unordered_map<char, int> occurrence;
        for (const auto &ch : s) {
            if (occurrence.find(ch) == occurrence.end()) {
                occurrence[ch] = 0;
            }
            occurrence[ch] += 1;
        }

        int max_occurrence = 0;
        char max_character;
        for (const auto &pair : occurrence) {
            if (max_occurrence < pair.second) {
                max_character = pair.first;
                max_occurrence = pair.second;
            }
        }

        if (max_occurrence > (s.length() + 1) / 2) {
            return "";
        }

        std::string answer(s.length(), '\0');
        int i = 0;
        while (max_occurrence > 0) {
            answer[i] = max_character;
            i += 2;
            max_occurrence--;
        }

        for (auto &pair : occurrence) {
            if (pair.first == max_character) {
                continue;
            }

            while (pair.second > 0) {
                if (i >= s.length()) {
                    i = 1;
                }
                answer[i] = pair.first;
                i += 2;
                pair.second--;
            }
        }

        return answer;
    }
};
