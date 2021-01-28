package com.example.tpfrangmentlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    monFragment1 frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        frag = (monFragment1) getSupportFragmentManager().findFragmentById(R.id.fragment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag.Message("ok");
                System.out.println("ok");
            }
        });
    }
}