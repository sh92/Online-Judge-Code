class MyCircularQueue:

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the queue to be k.
        :type k: int
        """
        self.mylist = [0 for i in range(k)]
        self.maxSize = k
        self.size = 0
        self.front = 0
        self.rear = 0
        

    def enQueue(self, value):
        """
        Insert an element into the circular queue. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.mylist[self.rear] = value
        self.size = self.size + 1
        self.rear = (self.rear + 1) % (self.maxSize)
        return True
        

    def deQueue(self):
        """
        Delete an element from the circular queue. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
           return False
        self.front = (self.front + 1) % self.maxSize
        self.size -= 1
        return True

    def Front(self):
        """
        Get the front item from the queue.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.mylist[self.front]
        

    def Rear(self):
        """
        Get the last item from the queue.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.mylist[self.rear-1]
        

    def isEmpty(self):
        """
        Checks whether the circular queue is empty or not.
        :rtype: bool
        """
        return (self.size == 0)
        

    def isFull(self):
        """
        Checks whether the circular queue is full or not.
        :rtype: bool
        """
        return (self.size == self.maxSize)
        
def excute_code( obj, methods, params):
    for idx in range(0,len(methods)):
        print(locals()[methods[idx]](params[idx][0]))


# Your MyCircularQueue object will be instantiated and called as such
method = ["enQueue", "Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
param = [[2],[],[],[],[],[],[],[4],[2],[2],[3]]


obj = MyCircularQueue(3)
print("rear",obj.Rear())
print("enque ",obj.enQueue(1))
print("rear",obj.Rear())
print("enque ",obj.enQueue(2))
print("rear",obj.Rear())
print("enque ",obj.enQueue(3))
print("rear",obj.Rear())
print("enque ",obj.enQueue(4))
print("rear",obj.Rear())
print("isFull",obj.isFull())
print("rear",obj.Rear())
print("deQueue",obj.deQueue())
print("rear",obj.Rear())
print("enQueue",obj.enQueue(4))
print("rear",obj.Rear())

'''
k = 3
obj = MyCircularQueue(k)
print("enque ",obj.enQueue(1))
print("enque 2 ",obj.enQueue(2))
print("enque 3 ",obj.enQueue(3))
print("enque 4 ",obj.enQueue(4))
print("deque ",obj.deQueue())
print("enque 5 ",obj.enQueue(5))
print("Front : ", obj.Front())
print("Rear : ",obj.Rear())
print("enque 6 ",obj.enQueue(6))
print("Empty : ",obj.isEmpty())
print("Full : " , obj.isFull())
print("deque ",obj.deQueue())
print("Empty : ",obj.isEmpty())
print("Full : " , obj.isFull())
print("deque ",obj.deQueue())
print("Empty : ",obj.isEmpty())
print("Full : " , obj.isFull())
print("deque ",obj.deQueue())
print("Empty : ",obj.isEmpty())
print("Full : " , obj.isFull())
'''
