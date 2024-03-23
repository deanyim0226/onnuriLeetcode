#include <unordered_map>
#include <queue>

using namespace std;

class LRUCache {
    int capacity;
    int id = 0;
    unordered_map<int, int> dict;
    unordered_map<int, int> validId;
    queue<pair<int, int>> history;
public:
    LRUCache(int capacity): capacity{capacity} {
    }
    
    int get(int key) {
        if (dict.count(key) > 0) {
            pair<int, int> tmp = {key, id};
            history.push(tmp);
            validId[key] = id;
            ++id;
            return dict[key];
        }
        return -1;
    }
    
    void put(int key, int value) {
        pair<int, int> tmp = {key, id};
        if (dict.count(key) > 0) {
            dict[key] = value;
            history.push(tmp);
            validId[key] = id;
        } else {
            if (capacity > 0) {
                dict[key] = value;
                history.push(tmp);
                validId[key] = id;
                --capacity;
            } else {
                while (history.front().second != validId[history.front().first]) {
                    history.pop();
                }
                dict[key] = value;
                history.push(tmp);
                validId[key] = id;
                auto deletedPair = history.front();
                history.pop();
                dict.erase(deletedPair.first);
                validId.erase(deletedPair.first);
            }
        }
        ++id;
    }
};