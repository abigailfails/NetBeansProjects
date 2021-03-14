package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void add(T data) {
        if (this.root != null) {
            traverse(data, this.root, true);
        } else this.root = new Node<>(data);
    }

    //Returns the parent node that was added to, or the node matching data if shouldAdd is false
    private Node<T> traverse(T data, Node<T> start, boolean shouldAdd) {
        Node<T> toTraverse;
        int comparison = data.compareTo(start.data);
        if (comparison > 0)
            toTraverse = start.getRight();
        else if (comparison < 0)
            toTraverse = start.getLeft();
        else {
            if (shouldAdd) throw new IllegalArgumentException("Inputted data already exists in tree!");
            return start;
        }
        if (toTraverse == null) {
            if (!shouldAdd) return null;
            Node<T> newNode = new Node<>(data);
            if (comparison > 0)
                start.setRight(newNode);
            else
                start.setLeft(newNode);
            return start;
        } else return traverse(data, toTraverse, shouldAdd);
    }

    public boolean contains(T data) {
        return traverse(data, this.root, false) != null;
    }

    public List<T> nodes(Traversal traversalType) {
        List<T> list = new ArrayList<>();
        addToList(this.root, list, traversalType);
        return list;
    }

    private void addToList(Node<T> start, List<T> list, Traversal traversalType) {
        if (traversalType == Traversal.PRE_ORDER)
            list.add(start.data);
        if (start.getLeft() != null)
            addToList(start.getLeft(), list, traversalType);

        if (traversalType == Traversal.IN_ORDER)
            list.add(start.data);
        if (start.getRight() != null)
            addToList(start.getRight(), list, traversalType);

        if (traversalType == Traversal.POST_ORDER)
            list.add(start.data);
    }

    public SortedMap<T, List<T>> sortedChildMap() {
        SortedMap<T, List<T>> map = new TreeMap<>();
        fillChildMap(this.root, map);
        return map;
    }

    public void fillChildMap(Node<T> start, SortedMap<T, List<T>> map) {
        List<T> children = new ArrayList<>();
        if (start.getLeft() != null) {
            children.add(start.getLeft().data);
            fillChildMap(start.getLeft(), map);
        }
        if (start.getRight() != null) {
            children.add(start.getRight().data);
            fillChildMap(start.getRight(), map);
        }
        map.put(start.data, children);
    }

    //TODO replace with nicer visual representation at some point
    @Override
    public String toString() {
        return this.sortedChildMap().toString();
    }

    public static class Node<T> {
        private final T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> leftChild, Node<T> rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeft() {
            return this.leftChild;
        }

        public void setLeft(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRight() {
            return this.rightChild;
        }

        public void setRight(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            else if (obj instanceof Node) {
                Node node = (Node) obj;
                return node.getData().equals(this.getData()) && node.getLeft() == this.getLeft() && node.getRight() == this.getRight();
            }
            return false;
        }
    }

    public enum Traversal {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER
    }
}