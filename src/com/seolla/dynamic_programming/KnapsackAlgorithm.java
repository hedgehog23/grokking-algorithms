package com.seolla.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnapsackAlgorithm {
    public ItemsValueTuple[][] find() {
        Map<String, WeightValueTuple> campingValues = getCampingValues();
        int knapsackWeight = 6;
        ItemsValueTuple[][] result = new ItemsValueTuple[5][6];
        List<Map.Entry<String, WeightValueTuple>> campingEntries = new ArrayList<>(campingValues.entrySet());
        for (int i = 0; i < campingValues.size(); i++) {
            Map.Entry<String, WeightValueTuple> campingEntry = campingEntries.get(i);
            for (int j = 0; j < knapsackWeight; j++) {
                ItemsValueTuple previous = i > 0 ? result[i - 1][j] : null;
                int previousValue = previous != null ? previous.value() : 0;
                ItemsValueTuple current = getCurrentCandidate(result, i, j, campingEntry);
                int currentValue = current != null ? current.value() : 0;
                if (currentValue > previousValue) {
                    result[i][j] = current;
                } else {
                    result[i][j] = previous;
                }
            }
        }
        return result;
    }

    private Map<String, WeightValueTuple> getCampingValues() {
        Map<String, WeightValueTuple> campingValues = new HashMap<>();
        campingValues.put("Water", new WeightValueTuple(3, 10));
        campingValues.put("Book", new WeightValueTuple(1, 3));
        campingValues.put("Food", new WeightValueTuple(2, 9));
        campingValues.put("Jacket", new WeightValueTuple(2, 5));
        campingValues.put("Camera", new WeightValueTuple(1, 6));
        return campingValues;
    }

    private ItemsValueTuple getCurrentCandidate(ItemsValueTuple[][] result, int row, int column,
            Map.Entry<String, WeightValueTuple> campingEntry) {
        int weight = campingEntry.getValue().weight();
        int value = campingEntry.getValue().value();
        String item = campingEntry.getKey();
        if ((column + 1) >= weight) {
            int freeWeight = (column + 1) - weight;
            if (freeWeight > 0 && row > 0 && result[row - 1][freeWeight - 1] != null) {
                ItemsValueTuple additional = result[row - 1][freeWeight - 1];
                List<String> items = new ArrayList<>(List.of(item));
                items.addAll(additional.items());
                int newValue = value + additional.value();
                return new ItemsValueTuple(items, newValue);
            }
            return new ItemsValueTuple(List.of(item), value);
        } else {
            return null;
        }
    }
}
