class MyCircularDeque:

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.mylist = []
        self.maxSize = k
        self.size = 0
        self.front = 0
        self.rear = k - 1

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.mylist.insert(self.front,value)
        self.size = self.size + 1
        return True

    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.mylist.insert(self.rear, value)
        self.size = self.size + 1
        return True
        

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.front = self.front + 1
        self.size = self.size - 1
        return True
        

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.front = self.front + 1
        self.size = self.size - 1
        return True 
        

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        return self.mylist[self.front]
        

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        return self.mylist[self.rear]
        

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        return (self.size == 0)
        

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        return (self.size == self.maxSize)
        


# Your MyCircularDeque object will be instantiated and called as such:
obj = MyCircularDeque(3)
param_1 = obj.insertFront(1)
param_2 = obj.insertLast(2)
param_3 = obj.deleteFront()
param_4 = obj.deleteLast()
param_5 = obj.getFront()
param_6 = obj.getRear()
param_7 = obj.isEmpty()
param_8 = obj.isFull()
