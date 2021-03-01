package tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StaticSearchTree<T extends Comparable<T>> {
    private final Node<T>[] nodes;

    @SuppressWarnings("unchecked")
    public StaticSearchTree(int size) {
        if (size > 0)
            this.nodes = (Node<T>[]) Array.newInstance(Node.class, size);
        else throw new IllegalArgumentException("Tree size must be greater than 0!");
    }

    public void add(T data) {
        if (nodes[0] != null)
            traverse(data, 0, true);
        else nodes[0] = new Node<>(data);
    }

    private int traverse(T data, int startIndex, boolean shouldAdd) {
        Node<T> startNode = nodes[startIndex];
        int nextIndex;
        int comparison = data.compareTo(startNode.data);
        if (comparison > 0)
            nextIndex = startNode.getRight();
        else if (comparison < 0)
            nextIndex = startNode.getLeft();
        else {
            if (shouldAdd) throw new IllegalArgumentException("Inputted data already exists in tree!");
            return startIndex;
        }
        if (nextIndex < 0) {
            if (shouldAdd) {
                int newNodeIndex = -1;
                for (int i=0; i<nodes.length && newNodeIndex < 0; i++) {
                    if (nodes[i] == null) {
                        nodes[i] = new Node<>(data);
                        newNodeIndex = i;
                    }
                }
                if (newNodeIndex < 0) throw new IllegalStateException("Tree is full and cannot accept new data!");
                if (comparison > 0)
                    startNode.setRight(newNodeIndex);
                else
                    startNode.setLeft(newNodeIndex);
                return newNodeIndex;
            } else return -1;
        } else return traverse(data, nextIndex, shouldAdd);
    }

    public Node<T>[] nodes() {
        return nodes.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(nodes);
    }

    public static class Node<T> {
        private final T data;
        private int leftIndex;
        private int rightIndex;

        public Node(T data) {
            this(data, -1, -1);
        }

        public Node(T data, int leftIndex, int rightIndex) {
            this.data = data;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

        public T getData() {
            return data;
        }

        public int getLeft() {
            return this.leftIndex;
        }

        public void setLeft(int leftIndex) {
            this.leftIndex = leftIndex;
        }

        public int getRight() {
            return this.rightIndex;
        }

        public void setRight(int rightIndex) {
            this.rightIndex = rightIndex;
        }

        @Override
        public String toString() {
            return data.toString() + "={L:" + leftIndex + ",R:" + rightIndex + '}';
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
}
