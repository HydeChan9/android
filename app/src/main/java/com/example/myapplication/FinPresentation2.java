package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.charset.StandardCharsets;

public class FinPresentation2 extends AppCompatActivity {
    private EditText et1=null;
    private EditText et2=null;
    private Button b1=null;
    private Button b2=null;
    String account="emp";
    String password="emp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_presentation2);
        setTitle("Login");
        et1=(EditText) findViewById(R.id.editTextTextPersonName75);
        et2=(EditText) findViewById(R.id.editTextTextPersonName76);
        b1=(Button)  findViewById(R.id.button100);
        b2=(Button) findViewById(R.id.button101);


        b1.setOnClickListener(bt1);
        b2.setOnClickListener(bt2);
    }

    View.OnClickListener bt1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String e1 = et1.getText().toString();
            String e2 = et2.getText().toString();
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference myRef = db.getInstance().getReference();
            if (et1.getText().toString().equals("")) {
                AlertDialog.Builder ad1 = new AlertDialog.Builder(FinPresentation2.this);
                ad1.setTitle("empty account");
                ad1.setMessage("empty account");
                ad1.show();
            } else {
                myRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                        if (snapshot.getKey().equals(e1)) {
                            password = snapshot.child("password").getValue().toString();
                            account = snapshot.getKey();
                        } else {

                        }
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                if (account.equals(e1) && password.equals(e2)) {
                    Intent i1 = new Intent(FinPresentation2.this, FinPresentation.class);
                    Bundle b = new Bundle();
                    b.putString("account", account);
                    i1.putExtras(b);
                    startActivity(i1);
                } else {
                    AlertDialog.Builder ad = new AlertDialog.Builder(FinPresentation2.this);
                    ad.setTitle("Login");
                    ad.setView(android.R.layout.simple_list_item_1);
                    ad.setMessage("Not exists account");
                    ad.show();
                    account = "emp";
                    password = "emp";
                }
            }
        }
    };

    View.OnClickListener bt2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i2=new Intent(FinPresentation2.this,FinPresentation.class);
            startActivity(i2);
        }
    };
}