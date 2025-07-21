class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        y = 0
        neg = x < 0
        tx = -x if neg else x
        while tx > 0:
            r = tx % 10
            y = 10 * y + r
            tx = tx // 10
        
        y = -y if neg else y

        if x > 0 and y > 0:
            return y
        elif x < 0 and y < 0:
            return y
        else:
            return 0
        
sol = Solution()
print(sol.reverse(-123))