class MyLinkedList {
private:
    int size = 0;
    struct Node{
        int val;
        Node* next;

        Node(int val, Node* next=nullptr):
            val{val}, next{next} {}
        
    };

    Node* head;
public:
    MyLinkedList() {
        head = nullptr;
    }
    
    int get(int index) {
        if (index >= size) return -1;
        Node* cur = head;
        while (index > 0) {
            --index;
            cur = cur->next;
        }
        return cur->val;
    }
    
    void addAtHead(int val) {
        Node* new_head = new Node(val, head);
        head = new_head;
        ++size;
    }
    
    void addAtTail(int val) {
        Node* cur = head;
        if (!cur) {
            addAtHead(val);
        } else {
            ++size;
            while (cur->next) {
                cur = cur->next;
            }
            cur->next = new Node(val);
        }
    }
    
    void addAtIndex(int index, int val) {
        if (index == 0) {
            head = new Node(val, head);
            ++size;
        }
        else if (index <= size) {
            Node* cur = head;
            while (index > 1) {
                cur = cur->next;
                --index;
            }
            Node* nxt = cur->next;
            cur->next = new Node(val, nxt);
            ++size;
        }
    }
    
    void deleteAtIndex(int index) {
        if (index < size) {
            if (index == 0) {
                head = head->next;
                --size;
            }
            else {
                Node* cur = head;
                while (index > 1) {
                    cur = cur->next;
                    --index;
                }
                cur->next = cur->next->next;
                --size;
            }
        }
    }
};
