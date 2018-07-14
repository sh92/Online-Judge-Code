class Solution:
    def shortestToChar(self, S, C):
        """
        :type S: str
        :type C: str
        :rtype: List[int]
        """
        ret = [ -1 for _ in range(len(S))]
        l = list(S)
        
        
        i = len(l)+10
        for k in range(0, len(l)):
            i = i + 1
            if l[k] == C:
                i = 0
            ret[k] = i
        
        i = len(l)+10
        for k in range(len(l)-1, -1, -1):
            i = i + 1
            if l[k] == C:
                i = 0
            ret[k] = min(i,ret[k])
        return ret
