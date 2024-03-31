package com.example.finalpredprof;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.finalpredprof.api.ContrillerPost;
import com.example.finalpredprof.domain.CountFloorsUseCase;
import com.example.finalpredprof.room.room_logic.RoomHandler;
import com.example.finalpredprof.room.models.AllData;
import com.example.finalpredprof.room.models.Data;
import com.example.finalpredprof.room.models.Date;
import com.example.finalpredprof.room.models.Floor;
import com.example.finalpredprof.room.models.Message;
import com.example.finalpredprof.room.models.Windows;
import com.example.finalpredprof.room.models.WindowsForRoom;

import java.util.ArrayList;
import java.util.List;

import com.example.finalpredprof.api.Controller;

public class MainActivity extends AppCompatActivity {
    private Button buttonAdd;
    private Button buttonDate;
    private EditText textInDate;
    private TextView textNumberRooms;
    private TextView textCorrectData;
    private GridView gridView;

    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.button_svoi_dannye);
        buttonDate = findViewById(R.id.button);
        textInDate = findViewById(R.id.data_vvod);
        textNumberRooms = findViewById(R.id.number_room);
        textCorrectData = findViewById(R.id.data_correct);
        gridView = findViewById(R.id.grid_view);
        list = new ArrayList<>();


        buttonDate.setOnClickListener(l -> {
            try {
            String[] date = textInDate.getText().toString().split("-");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            // retrofit

                Controller controller = new Controller(day, month, year);
                controller.run();
                controller.data.observeForever(d -> {
                    CountFloorsUseCase countFloorsUseCase = new CountFloorsUseCase();
                    list = countFloorsUseCase.execute(d.getWindows().getData(), d.getWindowsForRoom().getData());

                });
            } catch (Exception e){}
        });

        buttonAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            MainActivity.this.startActivity(intent);
        });


            Thread th2 = new Thread(() -> { // Тест работы БД

                AllData allData = new AllData();

                Message message = new Message();
                Data data = new Data();
                Date date = new Date();
                Date roomsCount = new Date();

                Floor floor1 = new Floor();
                Floor floor2 = new Floor();
                Windows windows = new Windows();
                WindowsForRoom windowsForRoom = new WindowsForRoom();


                ArrayList<Integer> data_windows_for_room = new ArrayList<>();
                data_windows_for_room.add(3);
                data_windows_for_room.add(2);
                data_windows_for_room.add(1);
                windowsForRoom.setData(data_windows_for_room);
                windowsForRoom.setDescription("Количество окон в каждой из комнат на этаже слева направо");

                ArrayList<Boolean> lightArr_floor1 = new ArrayList<>();
                lightArr_floor1.add(false);
                lightArr_floor1.add(true);
                floor1.setLightArr(lightArr_floor1);

                ArrayList<Boolean> lightArr_floor2 = new ArrayList<>();
                lightArr_floor2.add(true);
                lightArr_floor2.add(false);
                floor2.setLightArr(lightArr_floor2);

                ArrayList<Floor> floors_data = new ArrayList<>();
                floors_data.add(floor1);
                floors_data.add(floor2);
                data.setFloors(floors_data);

                date.setData(1674594000);
                date.setDescription("Татьянин день");

                roomsCount.setData(3);
                roomsCount.setDescription("Количество комнат на этаже");


                windows.setData(data);
                windows.setDescription("Окна по этажам, в которых горит свет");

                message.setDate(date);
                message.setRoomsCount(roomsCount);
                message.setWindowsForRoom(windowsForRoom);
                message.setWindows(windows);

                allData.setMessage(message);

                RoomHandler.getInstance(getApplication()).getAppDatabase().dataDao().insertAll(allData);
                List<AllData> lst = RoomHandler.getInstance(getApplication()).getAppDatabase().dataDao().getAllData();
                Log.d("123", String.valueOf(lst.size()));
            });

        th2.start();

    }
}