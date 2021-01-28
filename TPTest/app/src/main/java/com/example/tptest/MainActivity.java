package com.example.tptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogRecord monBuilder = null;
        monBuilder.setMessage("Mon Message");
        monBuilder.setTitle
    }
}