package com.seolla.dijkstra;

import java.util.List;

public record DijkstraResult(
        List<String> path,
        Integer costs
) {
}
