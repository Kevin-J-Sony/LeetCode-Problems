class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """

        def createPalindrome(i, j):
            l = ""
            while j < len(s) and i >= 0 and (s[i] == s[j]):
                l = s[i : j + 1]
                i = i - 1
                j = j + 1
            return l

        long_pal_substring = ""
        for i in range(len(s) - 1):
            odd = createPalindrome(i, i)
            even = createPalindrome(i, i+1)

            if len(odd) > len(long_pal_substring):
                long_pal_substring = odd
            if len(even) > len(long_pal_substring):
                long_pal_substring = even
            
        return long_pal_substring
        


sol = Solution()
print(sol.longestPalindrome("babad"))