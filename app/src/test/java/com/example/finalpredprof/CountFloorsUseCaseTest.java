package com.example.finalpredprof;

import com.example.finalpredprof.domain.CountFloorsUseCase;
import com.example.finalpredprof.domain.GetFloorsUseCase;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountFloorsUseCaseTest {
    private final CountFloorsUseCase useCase = new CountFloorsUseCase();

    @Test
    public void count_floors_returns_right_data() {
        HashMap<String, List<Boolean>> data = new HashMap<>();
        data.put("floor_1", new ArrayList<>(List.of(true, false, false, false, false, true)));
        data.put("floor_2", new ArrayList<>(List.of(false, false, false, true, true, false)));
        List<Integer> expected = List.of(1, 3, 5);
        assert useCase.execute(data, new ArrayList<>(List.of(3, 2, 1))).equals(expected);
    }
}
