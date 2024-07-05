Binary-Search-Tree-Implementation
===

This project showcases a comprehensive implementation of a Binary Search Tree (BST) in Java. A BST is a foundational data structure that supports efficient insertion, deletion, and search operations, making it ideal for various applications, including database indexing, sorting, and dynamic sets.

Features
---

Efficient Operations: Supports efficient insertion, deletion, and search operations.
In-Order Traversal: Provides an in-order traversal method to retrieve keys in sorted order.
Dynamic Size Calculation: Keeps track of the number of nodes in the tree dynamically.
Flexible Key-Value Storage: Stores key-value pairs, allowing the tree to be used for various mapping applications.

Implementation Details
---
Core Methods
---
put(Key key, Value value): Inserts a key-value pair into the BST. If the key already exists, its value is updated.
get(Key key): Retrieves the value associated with the specified key. Returns null if the key is not found.
deleteMin(): Deletes the minimum key (and its associated value) from the BST.
keys(): Returns an iterable collection of all keys in the BST, in sorted order.
Private Helper Methods
---
put(Node node, Key key, Value value): Recursive helper method for insertion.
get(Key key, Node node): Recursive helper method for retrieval.
deleteMin(Node node): Recursive helper method for deleting the minimum node.
size(Node node): Returns the number of nodes in the subtree rooted at the specified node.
keys(Node node, Queue<Key> queue): Recursive helper method for in-order traversal.
