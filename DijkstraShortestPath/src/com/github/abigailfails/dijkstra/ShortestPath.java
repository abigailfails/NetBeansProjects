package com.github.abigailfails.dijkstra;

import com.github.abigailfails.graph.WeightedGraph;
import com.github.abigailfails.hashmap.SimpleHashMap;
import com.github.abigailfails.queue.PriorityQueue;

import java.util.Map;

public class ShortestPath {
    public static<V> String[] shortestPaths(WeightedGraph<V> graph, V start) {
        int size = graph.adjacencyMap().size();
        Map<V, NodeInfo<V>> nodeInfo = new SimpleHashMap<>(size);
        for (V node : graph.adjacencyMap().keySet())
            nodeInfo.put(node, new NodeInfo<>(null, node == start ? 0 : Double.POSITIVE_INFINITY));
        PriorityQueue<V> queue = new PriorityQueue<>();
        queue.add(start, 0);
        while (!queue.isEmpty()) {
            double cost = queue.peekPriority();
            V current = queue.peekValue();
            nodeInfo.put(current, new NodeInfo<>(null, cost));
            for (V node : graph.childSet()) {
                if(!nodeInfo.containsKey(node)) {
                    double newCost = cost +
                }
            }
        }
    }

    /*public static<V> int[] shortestPaths(WeightedGraph<V>, V start, V end) {

    }*/

    static class NodeInfo<V> {
        V previous;
        double distance;

        public NodeInfo(V previous, double distance) {
            this.previous = previous;
            this.distance = distance;
        }

        public V getPrevious() {
            return this.previous;
        }

        public void setPrevious(V previous) {
            this.previous = previous;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }
    }
}
