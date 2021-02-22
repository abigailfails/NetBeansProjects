package graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderedWeightedGraphTest {

    private static OrderedWeightedGraph<Character> createTestGraph() {

        OrderedWeightedGraph<Character> graph = new OrderedWeightedGraph<>();

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

    @Test
    public void test1CreateGraph() {
        assertEquals("Test 1: toString: {A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,D:5,G:2},D:{A:8,C:5,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", "{A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,D:5,G:2},D:{A:8,C:5,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", createTestGraph().toString());
    }

    @Test
    public void test2RemoveEdgeUndirected() {
        OrderedWeightedGraph<Character> graph = createTestGraph();
        graph.removeEdgeUndirected('C', 'D');
        assertEquals("Test 2: removeEdgeUndirected: {A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", "{A:{B:5,D:8,E:4},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,E:7,F:6},E:{A:4,D:7},F:{D:6},G:{C:2}}", graph.toString());
    }

    @Test
    public void test3RemoveNode() {
        OrderedWeightedGraph<Character> graph = createTestGraph();
        graph.removeEdgeUndirected('C', 'D');
        graph.removeNode('E');
        assertEquals("Test 2: removeEdgeUndirected: {A:{B:5,D:8},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,F:6},F:{D:6},G:{C:2}}", "{A:{B:5,D:8},B:{A:5,C:4},C:{B:4,G:2},D:{A:8,F:6},F:{D:6},G:{C:2}}", graph.toString());

    }

}
