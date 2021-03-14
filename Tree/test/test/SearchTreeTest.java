package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tree.SearchTree;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SearchTreeTest {
    @SafeVarargs
    public static<T> List<T> list(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }

    public static<T> Map.Entry<T, List<T>> entry(T key, List<T> value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    public static SearchTree<String> filledTree() {
        SearchTree<String> tree = new SearchTree<>();
        tree.add("Jim");
        tree.add("Kevin");
        tree.add("Alice");
        tree.add("Belinda");
        return tree;
    }

    //An adjacency list probably isn't the best way to represent a tree, but it works for now
    @Test
    public void test1Add() {
        SearchTree<String> tree = filledTree();
        List<Map.Entry<String, List<String>>> testList = new ArrayList<>();
        testList.add(entry("Alice", list("Belinda")));
        testList.add(entry("Belinda", Collections.emptyList()));
        testList.add(entry("Jim", list("Alice", "Kevin")));
        testList.add(entry("Kevin", Collections.emptyList()));
        Assertions.assertEquals(testList, new ArrayList<>(tree.sortedChildMap().entrySet()), "Test 1: add: {Alice:[Belinda],Belinda:[],Jim:[Alice,Kevin],Kevin:[]}");
    }

    @Test
    public void test2ToString() {
        SearchTree<String> tree = filledTree();
        Assertions.assertEquals("{Alice=[Belinda], Belinda=[], Jim=[Alice, Kevin], Kevin=[]}", tree.toString(), "Test 2: toString: {Alice:[Belinda],Belinda:[],Jim:[Alice,Kevin],Kevin:[]}");
    }

    @Test
    public void test3Contains() {
        SearchTree<String> tree = filledTree();
        Assertions.assertTrue(tree.contains("Alice"));
    }

    @Test
    public void test4Contains() {
        SearchTree<String> tree = filledTree();
        Assertions.assertFalse(tree.contains("Bob"));
    }

    @Test
    public void test5NodesPreOrder() {
        SearchTree<String> tree = filledTree();
        Assertions.assertEquals(list("Jim", "Alice", "Belinda", "Kevin"), tree.nodes(SearchTree.Traversal.PRE_ORDER), "Test 5: nodes (pre order): [Jim, Alice, Belinda, Kevin]");
    }

    @Test
    public void test6NodesInOrder() {
        SearchTree<String> tree = filledTree();
        Assertions.assertEquals(list("Alice", "Belinda", "Jim", "Kevin"), tree.nodes(SearchTree.Traversal.IN_ORDER), "Test 6: nodes (in order): [Alice, Belinda, Jim, Kevin]");
    }

    @Test
    public void test7NodesPostOrder() {
        SearchTree<String> tree = filledTree();
        Assertions.assertEquals(list("Belinda", "Alice", "Kevin", "Jim"), tree.nodes(SearchTree.Traversal.POST_ORDER), "Test 7: nodes (post order): [Belinda, Alice, Kevin, Jim]");
    }
}
