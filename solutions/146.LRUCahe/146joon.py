class Node:
    def __init__(self,key , val):
        self.key = key
        self.val = val
        self.prev = self.next = None

class LRUCache:

    def __init__(self, capacity: int):

        self.cache = {}
        self.cap = capacity
        self.left , self.right = Node(0,0) , Node(0,0)
        self.left.next , self.right.prev = self.right , self.left

    #To be done at Linked List Level
    def remove(self, node):
        prev, nxt = node.prev , node.next
        prev.next , nxt.prev = nxt , prev

    def insert(self, node):
        prev, nxt = self.right.prev , self.right
        prev.next , nxt.prev = node  , node
        node.prev , node.next = prev , nxt

    ##################################################
    def get(self, key: int) -> int:

        if key in self.cache:
            self.remove(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].val

        return -1

    def put(self, key: int, value: int) -> None:
        #이미 Cache에 존재한다면, 리스트 상에서 제거
        if key in self.cache:
            self.remove(self.cache[key])
            #Cache는 제거 할 필요 없다 왜냐면 어차피 insert 이제 할꺼니!

        #Cache는 만들어놔야지!
        self.cache[key] = Node(key,value)
        #리스트에 둬야지!
        self.insert(self.cache[key])

        #근데 사이즈 너무 클경우, lru 를 remove 하기!
        if len(self.cache) > self.cap:
            #lru 찾기
            lru = self.left.next
            #리스트 상 에서 제거
            self.remove(lru)
            #캐쉬 상 에서 제거
            del self.cache[lru.key]


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)