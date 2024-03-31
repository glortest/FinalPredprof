package com.example.finalpredprof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finalpredprof.api.Controller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller = new Controller(25,1, 23);
        controller.run();
    }


}