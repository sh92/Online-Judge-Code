class Solution:
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        
        ret = []
        rdic = {}
        for x in cpdomains:
            num, site = x.split(" ")
            dlist = site.split(".")
            root = dlist[-1]
            if root in rdic.keys():
                rdic[root] += int(num)
            else:
                rdic[root] = int(num)
                
            if len(dlist) > 1:
                cpd = dlist[-2]+"."+ dlist[-1] 
                cpd = cpd.replace(" ","")
                if cpd in rdic.keys():
                    rdic[cpd] += int(num)
                else:
                    rdic[cpd] = int(num)
            if len(dlist) == 3:
                if site in rdic.keys():
                    rdic[site] += int(num)
                else:
                    rdic[site] = int(num)
        
        for k,v in rdic.items():
            ret.append(str(v)+" "+k)
        return ret
                
