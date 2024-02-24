class MyStack:

    def __init__(self):

        self.one_queue = deque()

    def push(self, x: int) -> None:


        self.one_queue.append(x)

        for i in range(len(self.one_queue) - 1):
            temporary = self.one_queue.popleft()
            self.one_queue.append(temporary)

    def pop(self) -> int:
        return self.one_queue.popleft()


    def top(self) -> int:
        return self.one_queue[0]


    def empty(self) -> bool:

        return len(self.one_queue) == 0
