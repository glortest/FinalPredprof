package com.example.finalpredprof;

import com.example.finalpredprof.domain.GetFloorsUseCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetFloorsUseCaseTest {
    private final GetFloorsUseCase useCase = new GetFloorsUseCase();

    @Test
    public void get_floors_returns_right_data() {
        HashMap<String, List<Boolean>> data = new HashMap<>();
        data.put("floor_1", new ArrayList<>(List.of(true, false, false, false, false, true)));
        data.put("floor_2", new ArrayList<>(List.of(false, false, false, true, true, false)));
        List<Boolean> expected = new ArrayList<>(List.of(true, false, false, false, false, true, false, false, false, true, true, false));
        assert useCase.getFloors(data).equals(expected);
    }
}
