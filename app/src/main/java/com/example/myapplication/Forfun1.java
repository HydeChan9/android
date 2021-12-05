package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forfun1 extends AppCompatActivity {
    private Button b1=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forfun1);
    b1=(Button) findViewById(R.id.button);

    b1.setOnClickListener(bt1);
    }
    View.OnClickListener bt1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder ad=new AlertDialog.Builder(Forfun1.this);
            ad.setMessage("test");
            ad.show();
        }
    };
}