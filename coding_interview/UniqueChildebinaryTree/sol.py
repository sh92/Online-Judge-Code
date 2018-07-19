class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def count(node):
    if node is None:
        return 0
    queue = []
    cnt = 0
    queue.append(root)
    while(len(queue) > 0 ):
        node = queue.pop(0)
        cnt +=1
        if node.left is not None:
             queue.append(node.left)
        if node.right is not None:
             queue.append(node.right)
    return cnt

def recursive_count(node):
    if node is None:
        return 0
    if node.left is None and node.right is  None:
        return 1
    if node.left is not None:
        l = recursive_count(node.left)
    if node.right is not None:
        r = recursive_count(node.right)
    return l + r + 1

def distinct_count(node):
    if node is None:
        return 0
    queue = []
    val_set = set()
    cnt = 0
    queue.append(root)
    while(len(queue) > 0 ):
        node = queue.pop(0)
        val_set.add(node.data)
        cnt +=1
        if node.left is not None:
             queue.append(node.left)
        if node.right is not None:
             queue.append(node.right)
    return len(val_set)

root = Node(10)
root.right = Node(50)
root.right.left = Node(40)
root.right.right= Node(100)
root.left = Node(5)
root.left.right = Node(40)
root.left.left = Node(1)
print(count(root))
print(recursive_count(root))
print(distinct_count(root))
