package com.github.abigailfails.graph;

import com.github.abigailfails.hashmap.SimpleHashMap;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class WeightedGraph<V> {
    private final Map<V, Map<V, Integer>> nodes = new SimpleHashMap<>();

    public final void addNode(V node) {
        this.nodes.put(node, new SimpleHashMap<>());
    }

    public void removeNode(V node) {
        this.nodes.remove(node);
        for (Map.Entry<V, Map<V, Integer>> entry : this.nodes.entrySet()) {
            if (entry.getValue().containsKey(node))
                this.nodes.get(entry.getKey()).remove(node);
        }
    }

    public void addEdgeUndirected(V startNode, V endNode, int weight) {
        this.addEdgeDirected(startNode, endNode, weight);
        this.addEdgeDirected(endNode, startNode, weight);
    }

    public void addEdgeDirected(V startNode, V endNode, int weight) {
        this.nodes.get(startNode).put(endNode, weight);
        if (!this.nodes.containsKey(endNode)) this.nodes.put(endNode, new SimpleHashMap<>());
    }

    public void removeEdgeUndirected(V startNode, V nodeToDisconnect) {
        this.removeEdgeDirected(startNode, nodeToDisconnect);
        this.removeEdgeDirected(nodeToDisconnect, startNode);
    }

    public void removeEdgeDirected(V startNode, V nodeToDisconnect) {
        this.nodes.get(startNode).remove(nodeToDisconnect);
    }

    public Map<V, Map<V, Integer>> adjacencyMap() {
        Map<V, Map<V, Integer>> map = new SimpleHashMap<>();
        map.putAll(this.nodes);
        return map;
    }

    public Map<V, Integer> childMap(V node) {
        Map<V, Integer> childMap = this.nodes.get(node);
        return childMap != null ? new SimpleHashMap<>(childMap) : new SimpleHashMap<>();
    }

    public Set<V> childSet(V node) {
        return this.nodes.get(node).keySet();
    }

    public boolean contains(V node) {
        return this.nodes.containsKey(node);
    }
}
