'''
62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.

'''
# Recursive Approach

class Solution:
    def __init__(self):
        self.path = 0
        
    def paths(self,x,y,m,n):
        if x>m or y>n:
            return
        if x == m and y == n:
            self.path+=1
        self.paths(x+1,y,m,n)
        self.paths(x,y+1,m,n)
        return path
    
    def uniquePaths(self, m: int, n: int) -> int:
        self.paths(1,1,m,n)
        return self.path
        

# Dynamic Programming

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp =[[1 for x in range(n)] for x in range(m)]
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]
