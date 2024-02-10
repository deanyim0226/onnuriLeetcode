def isPowerOfTwo(self, n: int) -> bool:

    def dfs(current):

        # If we got up to this far, this means it is a power of two. return true
        if current == 1 :
            return True

        # this means that it is a number NOT power of Two. Immediately return false
        elif current % 2 != 0 or current < 1:
            return False

        return dfs(current//2)

    return dfs(n)
