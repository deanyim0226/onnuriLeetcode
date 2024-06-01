import heapq
import defaultdict

class Twitter:

    def __init__(self):
        self.users = defaultdict(lambda: {"posts": [], "following": set()})
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.users[userId]["posts"].append((self.time, tweetId))
        self.time += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        pq = []
        for elem in self.users[userId]["posts"]:
            heapq.heappush(pq, elem)
            if len(pq) > 10:
                heapq.heappop(pq)

        for other in self.users[userId]["following"]:
            for elem in self.users[other]["posts"]:
                heapq.heappush(pq, elem)
                if len(pq) > 10:
                    heapq.heappop(pq)
        ans = []
        while pq:
            ans.append(heapq.heappop(pq)[1])
        return ans[::-1]

    def follow(self, followerId: int, followeeId: int) -> None:
        self.users[followerId]["following"].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.users[followerId]["following"].discard(followeeId)