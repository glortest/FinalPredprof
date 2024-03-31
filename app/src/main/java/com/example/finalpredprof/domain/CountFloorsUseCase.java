package com.example.finalpredprof.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CountFloorsUseCase {
    public CountFloorsUseCase() {
        
    }

    public List<Integer> execute(Map<String, List<Boolean>> floors, List<Integer> configuration) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < configuration.size(); i++) {
            if (i != 0) {
                configuration.set(i, configuration.get(i - 1) + configuration.get(i)); // разбиение на комнаты
            }
        }

        int counter = 0;

        List<String> keys = new ArrayList<>(floors.keySet()); // работа с форматами данных
        Collections.sort(keys);


        for (String floor : keys) {
            for (int i = 0; i < configuration.size(); i++) {
                counter++;
                List<Boolean> gh;
                if (i == 0) {
                    gh = floors.get(floor).subList(0, configuration.get(i));
                } else {
                    gh = floors.get(floor).subList(configuration.get(i - 1), configuration.get(i)); // проверка на наличие горящих окон
                }
                if (gh.contains(true)) {
                    res.add(counter);
                }
            }
        }

        return res; // вывод результата в виде списка с номерами комнат

    }
}
