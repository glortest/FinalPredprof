package com.example.finalpredprof;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalpredprof.domain.CountFloorsUseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    private CountFloorsUseCase useCase = new CountFloorsUseCase();

    private EditText countRooms;
    private EditText countWindows;
    private EditText enabledWindows;
    private EditText etages;

    private TextView roomsEnabledTv;
    private TextView roomsEnabledList;
    private Button buttonSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data_layout);
        countRooms = findViewById(R.id.count_rooms);
        countWindows = findViewById(R.id.colichestvo_rooms);
        enabledWindows = findViewById(R.id.window_light);
        buttonSave = findViewById(R.id.save_button);
        roomsEnabledTv = findViewById(R.id.rooms_enabled);
        roomsEnabledList = findViewById(R.id.rooms_enabled_list);
        etages = findViewById(R.id.etages);

        buttonSave.setOnClickListener(v -> {
            try {
                Integer rooms = Integer.parseInt(countRooms.getText().toString());
                String windowsStr = countWindows.getText().toString();
                List<String> windowsStrs = Arrays.asList(windowsStr.split(" "));
                List<Integer> windowsLen = new ArrayList<>();
                for (int i = 0; i < windowsStrs.size(); i++) {
                    windowsLen.add(Integer.parseInt(windowsStrs.get(i)));
                }
                Integer etagesLen = Integer.parseInt(etages.getText().toString());
                String enabledStr = enabledWindows.getText().toString();
                List<String> enabledStrs = Arrays.asList(enabledStr.split(" "));
                List<Integer> enabled = new ArrayList<>();
                for (int i = 0; i < enabledStrs.size(); i++) {
                    enabled.add(Integer.parseInt(enabledStrs.get(i)));
                }
                Map<String, List<Boolean>> floors = new HashMap<>();
                for (int i = 0; i < etagesLen; i++) {
                    List<Boolean> windows = getWindows(windowsLen, enabled, i);
                    floors.put("floor_" + (i + 1), windows);
                }
                List<Integer> roomsEnabled = useCase.execute(floors, windowsLen);
                roomsEnabledTv.setText(roomsEnabled.size());
                roomsEnabledList.setText(roomsEnabled.toString());
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Некорректные данные", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @NonNull
    private static List<Boolean> getWindows(List<Integer> windowsLen, List<Integer> enabled, int i) {
        List<Boolean> windows = new ArrayList<>();
        int counter = 0;
        for (int j = 0; j < windowsLen.size(); j++) {
            for (int t = 0; t < windowsLen.get(j); t++) {
                windows.add(false);
                counter++;
            }
        }
        for (int j = 0; j < enabled.size(); j++) {
            if(enabled.get(j) < (i + 1) * counter && enabled.get(j) >= i * counter){
                windows.set(j % counter, true);
            }
        }
        return windows;
    }
}
