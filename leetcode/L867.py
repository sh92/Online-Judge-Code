class Solution:
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        rows, cols = len(A), len(A[0])
        sol = [[0] * rows for _ in range(cols)]
        for row in range(rows):
            for col in range(cols):
                sol[col][row] = A[row][col]
        return sol
