#include <queue>
using namespace std;

class MyStack {
public:
    queue<int> st;
    MyStack() {
    }
    
    void push(int x) {
        st.push(x);
        int sz = st.size();
        for (int i = 0; i < sz - 1; ++i) {
            st.push(st.front());
            st.pop();
        }
    }
    
    int pop() {
        int res = st.front();
        st.pop();
        return res;
    }
    
    int top() {
        return st.front();
    }
    
    bool empty() {
        return st.empty();
    }
};
