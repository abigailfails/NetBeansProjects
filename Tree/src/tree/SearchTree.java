package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void add(T data) {
        if (this.root != null) {
            insertNode(data, this.root);
        } else this.root = new Node<>(data);
    }

    private void insertNode(T data, Node<T> start) {
        Node<T> toTraverse;
        int comparison = data.compareTo(start.data);
        if (comparison > 0)
            toTraverse = start.getRight();
        else if (comparison < 0)
            toTraverse = start.getLeft();
        else throw new IllegalArgumentException("Inputted data already exists in tree!");
        if (toTraverse == null) {
            Node<T> newNode = new Node<>(data);
            if (comparison > 0)
                start.setRight(newNode);
            else
                start.setLeft(newNode);
        } else insertNode(data, toTraverse);
    }

    /*public boolean get(T data) {
      //TODO generalise internal add method to work for this
    }*/

    /*public void remove(T data) {
        //TODO add once solved rehousing problem
    }*/

    public SortedMap<T, List<T>> childMap() {
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
        return this.childMap().toString();
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
    }
}