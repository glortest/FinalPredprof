package com.example.finalpredprof.room.room_logic;

import androidx.room.TypeConverter;

import com.example.finalpredprof.room.models.Data;
import com.example.finalpredprof.room.models.Date;
import com.example.finalpredprof.room.models.Floor;
import com.example.finalpredprof.room.models.Message;
import com.example.finalpredprof.room.models.Windows;
import com.example.finalpredprof.room.models.WindowsForRoom;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<Floor> fromFloorList(String value) {
        Type listType = new TypeToken<ArrayList<Floor>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayListFloor(ArrayList<Floor> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static ArrayList<Boolean> fromBoolean(String value) {
        Type listType = new TypeToken<ArrayList<Boolean>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayListBoolean(ArrayList<Boolean> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static ArrayList<Integer> fromInteger(String value) {
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayListInteger(ArrayList<Integer> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Message fromMessage(String value) {
        Type listType = new TypeToken<Message>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toMessage(Message list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Data fromData(String value) {
        Type listType = new TypeToken<Data>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toData(Data list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Date fromDate(String value) {
        Type listType = new TypeToken<Date>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toDate(Date list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Floor fromFloor(String value) {
        Type listType = new TypeToken<Floor>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toFloor(Floor list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Windows fromWindows(String value) {
        Type listType = new TypeToken<Windows>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toWindows(Windows list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static WindowsForRoom fromWindowsForRoom(String value) {
        Type listType = new TypeToken<WindowsForRoom>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toWindowsForRoom(WindowsForRoom list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}