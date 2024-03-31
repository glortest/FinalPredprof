package com.example.finalpredprof.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GetFloorsUseCase {
    public List<Boolean> getFloors(Map<String, List<Boolean>> floors){
        List<String> keys = new ArrayList<>(floors.keySet()); // работа с форматами данных
        Collections.sort(keys);
        List<Boolean> res = new ArrayList<>();
        for(String key : keys){
            res.addAll(Objects.requireNonNull(floors.get(key)));
        }
        return res;
    }
}
