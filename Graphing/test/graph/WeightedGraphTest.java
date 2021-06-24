package graph;

import hashmap.SimpleHashMap;
import org.junit.Test;

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

    //TODO replace this bullshit with strings like before, just find a way to turn adjacency map into reliable string comparison
    private static<K,V> Map.Entry<K, V> of(K item, V weight) {
        return Map.entry(item, weight);
    }

    @SafeVarargs
    private static<K,V> Map<K, V> map(Map.Entry<K, V>... entries) {
        SimpleHashMap<K, V> map = new SimpleHashMap<>();
        for (var entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /*private static Map<Character, Map<Character, Integer>> correctAdjacencyMap(Map.Entry<Character, Map<Character, Integer>>... entries) {
        ww
    }*/


                                                                                                                                        /*"{A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,D:5,G:2},D:{A:8,C:5,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}"*/
    @Test
    public void test1CreateGraph() {
        assertEquals("Test 1: toString: {A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,D:5,G:2},D:{A:8,C:5,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", map(of('A',map(of('B',5),of('D',8),of('E')))), createTestGraph().adjacencyMap().entrySet().to);
    }

    @Test
    public void test2RemoveEdgeUndirected() {
        WeightedGraph<Character> graph = createTestGraph();
        graph.removeEdgeUndirected('C', 'D');
        assertEquals("Test 2: removeEdgeUndirected: {A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", "{A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", graph.toString());
    }

    @Test
    public void test3RemoveNode() {
        WeightedGraph<Character> graph = createTestGraph();
        graph.removeEdgeUndirected('C', 'D');
        graph.removeNode('E');
        assertEquals("Test 2: removeEdgeUndirected: {A:{B:5,D:8},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,F:6},F:{D:6},G:{C:2}}", "{A:{B:5,D:8},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,F:6},F:{D:6},G:{C:2}}", graph.toString());

    }
}
