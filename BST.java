/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable, Value> {
    private class Node {
        Node left = null;
        Node right = null;
        Key key;
        Value value;
        int count = 0;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }

    }

    private Node root;

    public void put(Key key, Value value) {

        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        if (cmp > 0) node.right = put(node.right, key, value);
        if (cmp == 0) {
            node.value = value;
        }

        node.count = 1 + size(node.left) + size(node.right);
        return node;

    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        keys(root, queue);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue) {
        if (node.left != null) keys(node.left, queue);
        queue.enqueue(node.key);
        if (node.right != null) keys(node.right, queue);
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(key, node.left);
        if (cmp > 0) return get(key, node.right);

        return node.value;

    }

    public void deleteMin() {
        // empty tree check
        if (root == null)
            return;
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null; // garbage collector
            return right;
        }

        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;

    }

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(4, "d");
        bst.put(1, "a");
        bst.put(3, "c");
        bst.put(2, "b");

        for (Integer item : bst.keys()) {
            System.out.println(item);
        }

        bst.deleteMin();
        bst.deleteMin();

        for (Integer item : bst.keys()) {
            System.out.println(item);
        }

    }
}
