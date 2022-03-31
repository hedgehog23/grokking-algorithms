package com.seolla.bfs;

import java.util.*;

public class BFSMain {
    public static void main(String[] args) {
//        mangoSellerTest();
        morningRoutineTest();
    }

    private static void mangoSellerTest() {
        Map<String, Deque<String>> graph = fillGraph();
        System.out.println(findMangoSeller(graph));
    }

    private static String findMangoSeller(Map<String, Deque<String>> graph) {
        Deque<String> searchQueue = new ArrayDeque<>(graph.get("you"));
        List<String> searched = new ArrayList<>();
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (searched.contains(person)) {
                continue;
            }
            if (isPersonMangoSeller(person)) {
                return person;
            } else {
                Deque<String> personQueue = graph.get(person);
                searchQueue.addAll(personQueue);
                searched.add(person);
            }
        }

        return null;
    }

    private static Map<String, Deque<String>> fillGraph() {
        Map<String, Deque<String>> graph = new HashMap<>();
        graph.put("you", new ArrayDeque<>(List.of("alice", "bob", "claire")));
        graph.put("bob", new ArrayDeque<>(List.of("anuj", "peggy")));
        graph.put("alice", new ArrayDeque<>(List.of("peggy")));
        graph.put("claire", new ArrayDeque<>(List.of("thom", "jonny")));
        graph.put("anuj", new ArrayDeque<>());
        graph.put("peggy", new ArrayDeque<>());
        graph.put("thom", new ArrayDeque<>());
        graph.put("jonny", new ArrayDeque<>());
        return graph;
    }

    private static boolean isPersonMangoSeller(String test) {
        return test.endsWith("m");
    }

    private static void morningRoutineTest() {
        List<String> routineTest0 = List.of("wake_up", "shower", "eat_breakfast", "brush_teeth");
        List<String> routineTest1 = List.of("wake_up", "brush_teeth", "eat_breakfast", "shower");
        List<String> routineTest2 = List.of("shower", "wake_up", "brush_teeth", "eat_breakfast");
        Map<String, Deque<String>> routineGraph = new HashMap<>();
        routineGraph.put("shower", new ArrayDeque<>(List.of("wake_up")));
        routineGraph.put("brush_teeth", new ArrayDeque<>(List.of("wake_up")));
        routineGraph.put("wake_up", new ArrayDeque<>());
        routineGraph.put("eat_breakfast", new ArrayDeque<>(List.of("brush_teeth")));
        System.out.println("Morning routine 0 is valid or not: " + isMorningRoutineValid(routineGraph, routineTest0));
        System.out.println("Morning routine 1 is valid or not: " + isMorningRoutineValid(routineGraph, routineTest1));
        System.out.println("Morning routine 2 is valid or not: " + isMorningRoutineValid(routineGraph, routineTest2));
    }

    private static boolean isMorningRoutineValid(Map<String, Deque<String>> routineGraph, List<String> routineToTest) {
        List<String> previousRoutines = new ArrayList<>();
        for (String routine : routineToTest) {
            Deque<String> routineQueue = routineGraph.get(routine);
            if (!previousRoutines.containsAll(routineQueue)) {
                return false;
            }
            previousRoutines.add(routine);
        }
        return true;
    }
}
