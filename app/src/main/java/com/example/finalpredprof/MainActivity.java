package com.example.finalpredprof;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

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
    private Button buttonDate;
    private Spinner spinnerData;
    private Spinner spinnerMonth;
    private Spinner spinnerYear;
    private TextView textNumberRooms;
    private TextView textCorrectData;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller = new Controller(25,1, 23);
        controller.run();

        Thread th2 = new Thread(() -> { // Тест работы БД

            AllData allData = new AllData();

            Message message = new Message();
            Data data = new Data();
            Date date = new Date();
            Date roomsCount = new Date();

            Floor floor = new Floor();
            Windows windows = new Windows();
            WindowsForRoom windowsForRoom = new WindowsForRoom();


            ArrayList<Integer> data_windows_for_room = new ArrayList<>();
            windowsForRoom.setData(data_windows_for_room);
            windowsForRoom.setDescription("description_windows_for_room");

            ArrayList<Boolean> lightArr_floor = new ArrayList<>();
            floor.setLightArr(lightArr_floor);

            ArrayList<Floor> floors_data = new ArrayList<>();
            floors_data.add(floor);
            data.setFloors(floors_data);

            date.setData(1);
            date.setDescription("desc_date");

            roomsCount.setData(2);
            roomsCount.setDescription("desc_roomCount");


            windows.setData(data);
            windows.setDescription("desc_windows");

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