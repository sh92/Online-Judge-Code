from collections import defaultdict

class Graph:
   def __init__(self, vertices):
      self.V = vertices
      self.graph = defaultdict(list)

   def addEdge(self, u, v):
      self.graph[u].append(v)

   def DFSUtil(self, v, visited):
      visited[v] = True
      for i in self.graph[v]:
          if visited[i] == False:
              self.DFSUtil(i, visited)

   def fillOrder(self,v,visited,stack):
      visited[v] = True
      for i in self.graph[v]:
         if visited[i] == False:
            self.fillOrder(i, visited, stack)
      stack = stack.append(v)

   def getTranspose(self):
      g = Graph(self.V)

      for i in self.graph:
         for j in self.graph[i]:
            g.addEdge(j,i)
      return g

   def printSCCs(self):
      stack = []
      visited = [False] * (self.V)

      for i in range(self.V):
          if visited[i] == False:
              self.fillOrder(i, visited, stack)

      gr = self.getTranspose()

      visited = [False] * (self.V)

      cnt = 0
      while stack:
         i = stack.pop()
         if visited[i] == False:
            cnt = cnt+1
            gr.DFSUtil(i, visited)
      print(cnt)


print("print number of scc ")
T = input()
for x in range(int(T)):
   nm = input()
   N, M = nm.split(" ")
   N, M = int(N), int(M)

   g = Graph(N)
   uvlist = input()
   uvlist = uvlist.split(" ")
   for i in range(0, len(uvlist),2):
      u, v = uvlist[i], uvlist[i+1]
      u, v = int(u), int(v)
      g.addEdge(u-1,v-1)
   g.printSCCs()

