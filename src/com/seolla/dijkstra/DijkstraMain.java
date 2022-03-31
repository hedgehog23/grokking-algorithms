package com.seolla.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class DijkstraMain {
    public static void main(String[] args) {
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        DijkstraResult result = algorithm.search("a", "c", buildGraph2());
        System.out.println(result.costs());
        System.out.println(result.path());
    }

    private static Map<String, Map<String, Integer>> buildGraph0() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("start", Map.of("a", 6, "b", 2));
        graph.put("a", Map.of("fin", 1));
        graph.put("b", Map.of("a", 3, "fin", 5));
        graph.put("fin", new HashMap<>());
        return graph;
    }

    private static Map<String, Map<String, Integer>> buildGraph1() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("start", Map.of("a", 5, "b", 2));
        graph.put("a", Map.of("c", 4, "d", 2));
        graph.put("b", Map.of("a", 8, "d", 7));
        graph.put("c", Map.of("fin", 3, "d", 6));
        graph.put("d", Map.of("fin", 1));
        graph.put("fin", new HashMap<>());
        return graph;
    }

    private static Map<String, Map<String, Integer>> buildGraph2() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("a", Map.of("b", 6, "d", 1));
        graph.put("b", Map.of("c", 5));
        graph.put("c", new HashMap<>());
        graph.put("d", Map.of("b", 2, "e", 1));
        graph.put("e", Map.of("b", 2, "c", 5));
        return graph;
    }
}
