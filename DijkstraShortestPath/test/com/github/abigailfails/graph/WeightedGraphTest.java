package com.github.abigailfails.graph;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WeightedGraphTest {


    private static WeightedGraph<Character> createTestGraph() {

        WeightedGraph<Character> graph = new WeightedGraph<>();

        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addNode('D');
        graph.addNode('E');
        graph.addNode('F');
        graph.addNode('G');

        graph.addEdgeUndirected('A','B',5);
        graph.addEdgeUndirected('A','D',8);
        graph.addEdgeUndirected('A','E',4);
        graph.addEdgeUndirected('B','C',4);
        graph.addEdgeUndirected('C','D',5);
        graph.addEdgeUndirected('C','G',2);
        graph.addEdgeUndirected('D','E',7);
        graph.addEdgeUndirected('D','F',6);

        return graph;
    }

    private static <V extends Comparable<V>> String toString(WeightedGraph<V> graph) {
        return mapToStringOrdered(graph.adjacencyMap());
    }

    @SuppressWarnings("unchecked")
    private static <K extends Comparable<K>, V> String mapToStringOrdered(Map<K, V> map) {
        StringBuilder output = new StringBuilder();
        output.append('{');
        for (Iterator<Map.Entry<K, V>> iterator = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).iterator(); iterator.hasNext(); ) {
            Map.Entry<K, V> entry = iterator.next();
            V value = entry.getValue();
            output.append(entry.getKey().toString()).append(':').append(value instanceof Map ? mapToStringOrdered((Map<K,?>) value) : value.toString()); //horribly unsafe but this method shouldn't be used outside test
            if (iterator.hasNext())
                output.append(',');
        }
        output.append('}');
        return output.toString();
    }

    @Test
    public void test1CreateGraph() {
        assertEquals("Test 1: toString: {A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,D:5,G:2},D:{A:8,C:5,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", "{A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,D:5,G:2},D:{A:8,C:5,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", toString(createTestGraph()));
    }

    @Test
    public void test2RemoveEdgeUndirected() {
        WeightedGraph<Character> graph = createTestGraph();
        graph.removeEdgeUndirected('C', 'D');
        assertEquals("Test 2: removeEdgeUndirected: {A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", "{A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", toString(graph));
    }

    @Test
    public void test3RemoveNode() {
        WeightedGraph<Character> graph = createTestGraph();
        graph.removeEdgeUndirected('C', 'D');
        graph.removeNode('E');
        assertEquals("Test 2: removeEdgeUndirected: {A:{B:5,D:8},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,F:6},F:{D:6},G:{C:2}}", "{A:{B:5,D:8},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,F:6},F:{D:6},G:{C:2}}", toString(graph));

    }
}
