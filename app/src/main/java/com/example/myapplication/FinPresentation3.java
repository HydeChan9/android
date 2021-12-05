package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class FinPresentation3 extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference myRef;
    private ListView lv1=null;
    private Button b1=null;
    String b="";
    String a="";
    String[] st1={"st0","st1"};
    String[] st2={"st1","st2"};
    //String[] st3={String.valueOf(R.mipmap.d5),String.valueOf(R.mipmap.d5)};
    String account1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_presentation3);
        Bundle bj=this.getIntent().getExtras();
        if (bj.equals("")){
            Intent i2=new Intent(FinPresentation3.this,FinPresentation.class);
            startActivity(i2);

        }else {
            account1 = bj.getString("account1");
            b1 = (Button) findViewById(R.id.button139);
            lv1 = (ListView) findViewById(R.id.ListView14);
            db = FirebaseDatabase.getInstance();
            myRef = db.getInstance().getReference();

            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    if (snapshot.getKey().equals(account1)) {
                        b = snapshot.child("balance").getValue().toString();
                        a = snapshot.child("available").getValue().toString();
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
        }
        ArrayList<HashMap<String, String>> ah = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < st1.length; i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("balance", st1[i]);
            hm.put("available", st2[i]);
      //      hm.put("cards", st3[i]);
            ah.add(hm);
        }

        String[] from = {"cards", "balance", "available"};
        //int[] to = {R.id.a1, R.id.textView66, R.id.textView67};
        //SimpleAdapter sa = new SimpleAdapter(this, ah, R.layout.style_listview2, from, to);

       // lv1.setAdapter(sa);
        lv1.setOnItemClickListener(se1);
        b1.setOnClickListener(bt1);
    }
    View.OnClickListener bt1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i2=new Intent(FinPresentation3.this,FinPresentation.class);
            startActivity(i2);
        }
    };


    AdapterView.OnItemClickListener se1=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    if (snapshot.getKey().equals(account1)){
                        b=snapshot.child("balance").getValue().toString();
                        a=snapshot.child("available").getValue().toString();
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

            String s1=st1[i];
            String s2=st2[i];
            String s3=s1+"  "+s2;
            AlertDialog.Builder ad=new AlertDialog.Builder(FinPresentation3.this);
            ad.setMessage(s3);
            ad.setTitle("test");
            ad.setPositiveButton("yes",null);
            ad.show();
        }
    };



}