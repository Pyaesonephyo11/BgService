package com.example.bgservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etinput=(EditText) findViewById(R.id.et_input);

    }

    public  void startService(View view){
        String input=etinput.getText().toString();
        Intent serviceIntent=new Intent(this,ExampleService.class);
        serviceIntent.putExtra("inp",input);
       ContextCompat.startForegroundService(this,serviceIntent);
        //startService(serviceIntent);
    }

    public void stopService(View view){
        Intent serviceInt=new Intent(this,ExampleService.class);
        stopService(serviceInt);
    }
}