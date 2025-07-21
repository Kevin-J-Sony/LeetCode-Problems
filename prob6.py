class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        
        
        '''
        This was the solution I came up with on my own.
        
        if numRows == 1:
            return s
        
        new_s = list(s)
        
        l = len(s)
        n = numRows
        m = n + (n - 2)
        
        num_of_elements = [0 for i in range(n)]
        for i in range(l):
            b = i % m
            if b < n:
                num_of_elements[b] += 1
            else:
                num_of_elements[2*(n - 1) - b] += 1

        
        for i in range(l):
            a = i // m
            b = i % m
            
            y = b if (b < n) else 2*(n - 1) - b
            
            total_elem = 0
            for j in range(y):
                total_elem += num_of_elements[j]
            
            # add in elements from offset
            if y == 0 or y == n - 1:
                total_elem += a
            else:
                total_elem += 2 * a
                total_elem += 0 if (b < n) else 1
    
            new_s[total_elem] = s[i]

        return "".join(new_s)
        
        The following is the solution that I understand, but didn't think of.
        '''
        if numRows == 1:
            return s
                
        n = numRows
        step = 1
        idx = 0
        
        row_str = ['' for i in range(n)]
        for i in range(len(s)):
            row_str[idx] += s[i]
            idx += step
            if idx == n - 1:
                step = -1
            elif idx == 0:
                step = 1
        
        return ''.join(row_str)
        
        

sol = Solution()
print(sol.convert("PAYPALISHIRING", 3))