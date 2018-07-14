class Solution:
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        op = []
        for n in range(left, right+1):
            if self.isSelfDividing(n):
                op.append(n)
        return op
        
    def isSelfDividing(self, n):
        origN = n
        op = True
        while ( n > 0 ):
            try:
                digit = n % 10
                if origN % digit !=0:
                    return False
                n = n //10
            except ZeroDivisionError:
                return False
        return op
a = Solution()
print(a.selfDividingNumbers(1,22))
