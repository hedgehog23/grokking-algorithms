package com.seolla.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
    public DijkstraResult search(String startNode, String finishNode, Map<String, Map<String, Integer>> graph) {
        String node = startNode;
        Map.Entry<Map<String, Integer>, Map<String, String>> costsAndParents = getCostsAndParents(startNode, graph);
        Map<String, Integer> costs = costsAndParents.getKey();
        Map<String, String> parents = costsAndParents.getValue();
        Set<String> processed = new HashSet<>();
        while (node != null) {
            Map<String, Integer> neighbors = graph.get(node);
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                Integer cost = costs.get(neighbor.getKey());
                if (cost > costs.get(node) + neighbor.getValue()) {
                    costs.put(neighbor.getKey(), costs.get(node) + neighbor.getValue());
                    parents.put(neighbor.getKey(), node);
                }
            }
            processed.add(node);
            node = findLowestNode(costs, processed);
        }

        return getResult(finishNode, costs, parents);
    }

    private Map.Entry<Map<String, Integer>, Map<String, String>> getCostsAndParents(String startNode,
            Map<String, Map<String, Integer>> graph) {
        Map<String, Integer> costs = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        for (String node : graph.keySet()) {
            if (node.equals(startNode)) {
                costs.put(node, 0);
            } else {
                costs.put(node, Integer.MAX_VALUE);
            }
            parents.put(node, null);
        }
        return Map.entry(costs, parents);
    }

    private String findLowestNode(Map<String, Integer> costs, Set<String> processed) {
        String lowestNode = null;
        Integer lowestCost = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> nodeCost : costs.entrySet()) {
            String node = nodeCost.getKey();
            Integer cost = nodeCost.getValue();
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestNode = node;
            }
        }

        return lowestNode;
    }

    private DijkstraResult getResult(String finish, Map<String, Integer> costs,
            Map<String, String> parents) {
        List<String> path = new ArrayList<>();
        String dest = finish;
        while (dest != null) {
            path.add(dest);
            dest = parents.get(dest);
        }
        Integer cost = costs.get(finish);
        Collections.reverse(path);
        return new DijkstraResult(path, cost);
    }
}
