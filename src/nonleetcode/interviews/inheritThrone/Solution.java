package nonleetcode.interviews.inheritThrone;

import java.util.*;

public class Solution {

/**

 class Node(object):
 def __init__(self, name):
 self.name = name
 self.children = []


 class Tree(object):

 def __init__(self, kingname):
 self.root = Node(kingname)
 self.order = [kingname]

 # birth
 def insert(self, fathername, childname):
 self.insertHelper(self.root, fathername, childname)

 # death
 def delete(self, name):
 self.deleteHelper(self.root, name)

 def getOrder(self):
 res = []
 self.preorder(self.root, res)
 return res

 def insertHelper(self, node, key, value):
 if len(node.children) == 0 and node.name != key:
 return
 if node.name == key:
 idx = -1
 if len(node.children) == 0:
 idx = self.order.index(node.name)
 else:
 idx = self.order.index(node.children[-1].name)
 self.order.insert(idx, value)

 node.children.append(Node(value))
 return

 for n in node.children:
 self.insertHelper(n, key, value)

 def deleteHelper(self, node, key):
 if node.name != key and len(node.children) == 0:
 return (False, None) # (shouldDelete, his_children)

 if node.name == key:
 self.order.remove(node.name)
 return (True, node.children)

 children = node.children
 for child in children:
 pairInfo = self.deleteHelper(child, key)
 if pairInfo[0]:
 children.remove(child)
 children += pairInfo[1]
 return (False, None)

 return (False, None)

 def preorder(self, node, res):
 if len(node.children) == 0:
 res.append(node.name)
 return
 res.append(node.name)
 for n in node.children:
 self.preorder(n, res)



 def test():
 tree = Tree("King")
 tree.insert("King", "A")
 tree.insert("A", "A1")
 tree.insert("A", "A2")
 tree.insert("A", "A3")

 tree.insert("A2", "A21")
 tree.insert("A2", "A22")
 tree.insert("A2", "A23")

 # tree.delete("A")



 print(tree.getOrder())

 test()

 */

    
}
