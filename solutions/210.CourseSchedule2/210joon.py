class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:


        visited_set = set()
        cycle_set = set()
        answer_array = []
        relationship = {}

        relationship = { i : [] for i in range(numCourses) }

        for course, prereq in prerequisites:
            relationship[course].append(prereq)

        #print(relationship)

        def dfs(current):

            nonlocal answer_array

            if current in cycle_set:
                return False

            if current in visited_set:
                return True

            cycle_set.add(current)

            for preReq in relationship[current]:
                if not dfs(preReq):
                    return False

            cycle_set.remove(current)
            visited_set.add(current)
            answer_array.append(current)
            return True
        #print(relationship)
        for course in relationship.keys():

            if not dfs(course):
                return []

        return answer_array
