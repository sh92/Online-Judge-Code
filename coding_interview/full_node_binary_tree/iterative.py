
class Node:
    def __init__(self ,key):
        self.data = key
        self.left = None
        self.right = None

def count(root):
    if root is None:
        return 0
    queue = []
    queue.append(root)
    count = 0
    while(len(queue) > 0 ):
        node = queue.pop(0)
        if node.left is not None and node.right is not None:
            count = count + 1
        if node.left is not None:
            queue.append(node.left)
        if node.right is not None:
            queue.append(node.right)
    return count

root = Node(2)
root.left = Node(8)
root.right = Node(6)
root.left.right = Node(7)
root.left.right.left = Node(1)
root.left.right.right = Node(12)
root.right.right = Node(10)
root.right.right.left = Node(4)
root.right.right.right = Node(11)
print(count(root))
