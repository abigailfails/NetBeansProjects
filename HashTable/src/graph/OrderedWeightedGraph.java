package graph;

import hashmap.SimpleHashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class OrderedWeightedGraph<V extends Comparable<V>> {
    private final SimpleHashMap<V, SimpleHashMap<V, Integer>> nodes = new SimpleHashMap<>();

    public static void main(String[] args) {
        OrderedWeightedGraph<Character> graph = new OrderedWeightedGraph<>();
        graph.addNode('Z');
        graph.addNode('A');
        graph.addNode('C');
        graph.addConnection('A', 'Z', 5, true);
        graph.addConnection('A', 'C', 10, true);
        graph.addConnection('C', 'Z', 2, false);
        System.out.println(graph.toString());
    }

    public final void addNode(V node) {
        this.nodes.put(node, new SimpleHashMap<>());
    }

    public void removeNode(V node) {
        this.nodes.remove(node);
        for (Map.Entry<V, SimpleHashMap<V, Integer>> entry : this.nodes.entrySet()) {
            if (entry.getValue().containsKey(node))
                this.nodes.get(entry.getKey()).remove(node);
        }
    }

    public void addConnection(V startNode, V endNode, int weight, boolean isBidirectional) {
        this.nodes.get(startNode).put(endNode, weight);
        if (!this.nodes.containsKey(endNode)) this.nodes.put(endNode, new SimpleHashMap<>());
        if (isBidirectional) this.nodes.get(endNode).put(startNode, weight);
    }

    public void removeConnection(V startNode, V nodeToDisconnect) {
        this.nodes.get(startNode).remove(nodeToDisconnect);
        this.nodes.get(nodeToDisconnect).remove(startNode);
    }

    public SortedMap<V, Integer> childMap(V node) {
        Map<V, Integer> childMap = this.nodes.get(node);
        return childMap != null ? new TreeMap<>(childMap) : new TreeMap<>();
    }

    public Set<V> childSet(V node) {
        return this.nodes.get(node).keySet();
    }

    public boolean contains(V node) {
        return this.nodes.containsKey(node);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<V> keys = new ArrayList<>(this.nodes.keySet());
        Collections.sort(keys);
        builder.append('{');
        for (int i=0; i<keys.size(); i++) {
            V key = keys.get(i);
            builder.append(key).append(":{");
            Map<V, Integer> value = this.nodes.get(key);
            List<V> subKeys = new ArrayList<>(value.keySet());
            Collections.sort(subKeys);
            for (int j=0; j<subKeys.size(); j++) {
                V subKey = subKeys.get(j);
                builder.append(subKey).append(":").append(value.get(subKey));
                if (j<subKeys.size()-1)
                    builder.append(',');
            }
            builder.append('}');
            if (i<keys.size()-1)
                builder.append(',');
        }
        builder.append('}');
        return builder.toString();
    }
}
