package com.example.finalpredprof.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GetFloorsUseCase {
    public List<Boolean> getFloors(Map<String, List<Boolean>> floors) {
        List<String> keys = new ArrayList<>(floors.keySet()); // работа с форматами данных
        keys.replaceAll(s -> s.replaceAll("[^0-9]", ""));
        Collections.sort(keys);

        List<Integer> keysInt = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            keysInt.add(Integer.parseInt(keys.get(i)));
        }
        Collections.sort(keysInt);
        List<Boolean> res = new ArrayList<>();
        for (Integer key : keysInt) {
            res.addAll(Objects.requireNonNull(floors.get("floor_" + key)));
        }
        return res;
    }
}
