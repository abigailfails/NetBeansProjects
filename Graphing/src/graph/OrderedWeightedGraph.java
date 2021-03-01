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

    //TODO move half of this to the hashmap and make this graph unordered
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
