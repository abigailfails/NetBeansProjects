package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tree.StaticSearchTree;

import static test.SearchTreeTest.list;

public class StaticSearchTreeTest {

    public static<T> StaticSearchTree.Node<T> node(T data, int left, int right) {
        return new StaticSearchTree.Node<>(data, left, right);
    }

    @Test
    public void test1Add() {
        StaticSearchTree<String> tree = new StaticSearchTree<>(4);
        tree.add("Jim");
        tree.add("Kevin");
        tree.add("Alice");
        tree.add("Belinda");
        Assertions.assertArrayEquals(list(node("Jim", 2, 1), node("Kevin", -1, -1), node("Alice", -1, 3), node("Belinda", -1, -1)).toArray(), tree.nodes(), "Test 1: add: [Jim={L:2, R:1}, Kevin={L:-1, R:-1}, Alice={L:-1, R:3}, Belinda={L:-1, R:-1}]");
    }

    @Test
    public void test2ToString() {
        StaticSearchTree<String> tree = new StaticSearchTree<>(4);
        tree.add("Jim");
        tree.add("Kevin");
        tree.add("Alice");
        tree.add("Belinda");
        Assertions.assertEquals("[Jim={L:2,R:1}, Kevin={L:-1,R:-1}, Alice={L:-1,R:3}, Belinda={L:-1,R:-1}]", tree.toString(), "Test 2: toString: [Jim={L:2,R:1}, Kevin={L:-1,R:-1}, Alice={L:-1,R:3}, Belinda={L:-1,R:-1}]");
    }
}
