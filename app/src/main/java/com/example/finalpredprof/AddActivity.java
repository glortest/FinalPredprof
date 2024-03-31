package com.example.finalpredprof;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    private EditText countRooms;
    private EditText countWindows;
    private EditText enabledWindows;
    private EditText etages;
    private Button buttonSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data_layout);
        countRooms = findViewById(R.id.count_rooms);
        countWindows = findViewById(R.id.colichestvo_rooms);
        enabledWindows = findViewById(R.id.window_light);
        buttonSave = findViewById(R.id.save_button);
        etages = findViewById(R.id.etages);

        buttonSave.setOnClickListener(v -> {
            try {
                Integer rooms = Integer.getInteger(countRooms.getText().toString());
                String windowsStr = countWindows.getText().toString();
                List<String> windowsStrs = Arrays.asList(windowsStr.split(" "));
                List<Integer> windowsLen = new ArrayList<>();
                for(int i = 0; i < windowsStrs.size(); i++){
                    windowsLen.add(Integer.getInteger(windowsStrs.get(i)));
                }
                Integer etagesLen = Integer.getInteger(etages.getText().toString());
                String enabledStr = enabledWindows.getText().toString();
                List<String> enabledStrs = Arrays.asList(enabledStr.split(" "));
                List<Integer> enabled = new ArrayList<>();
                for (int i = 0; i < enabledStrs.size(); i++) {
                    enabled.add(Integer.getInteger(enabledStrs.get(i)));
                }
                Map<String, List<Boolean>> floors = new HashMap<>();
                for(int i = 0; i < etagesLen; i++){


                }
            } catch (Exception e) {
                Toast.makeText(this, "Некорректные данные", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
