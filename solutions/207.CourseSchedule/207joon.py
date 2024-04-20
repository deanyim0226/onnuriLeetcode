import collections

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        adjacency_list = collections.defaultdict(list)

        for relationship in prerequisites:

            adjacency_list[ relationship[0]].append(relationship[1])


        #print(adjacency_list.items())

        visited_set = set()


        def dfs( current_course, visited_set , adjacency_list):

            # if this is a cycle
            if current_course in visited_set:
                return False


            if len(adjacency_list[current_course]) == 0:
                return True

            visited_set.add(current_course)

            for course in adjacency_list[current_course]:

                if not dfs(course ,visited_set ,adjacency_list ):
                    return False


            visited_set.remove(current_course)
            adjacency_list[current_course] = []

            return True


        for i in range(numCourses):
            if not dfs( i ,visited_set , adjacency_list ):
                return False

        return True




