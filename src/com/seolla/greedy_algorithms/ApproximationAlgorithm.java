package com.seolla.greedy_algorithms;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ApproximationAlgorithm {
    public Set<String> calculate() {
        Set<String> statesNeeded = new HashSet<>(getStates());
        Map<String, Set<String>> stations = getStations();
        Set<String> finalStations = new HashSet<>();

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();
            for (Map.Entry<String, Set<String>> stationEntry : stations.entrySet()) {
                String station = stationEntry.getKey();
                Set<String> stateForStation = new HashSet<>(stationEntry.getValue());
                stateForStation.retainAll(statesNeeded);
                if (stateForStation.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = stationEntry.getValue();
                }
            }
            finalStations.add(bestStation);
            statesNeeded.removeAll(statesCovered);
        }
        return finalStations;
    }

    private Set<String> getStates() {
        return Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az");
    }

    private Map<String, Set<String>> getStations() {
        return Map.of(
                "kone", Set.of("id", "nv", "ut"),
                "ktwo", Set.of("wa", "id", "mt"),
                "kthree", Set.of("or", "nv", "ca"),
                "kfour", Set.of("nv", "ut"),
                "kfive", Set.of("ca", "az")
        );
    }
}
