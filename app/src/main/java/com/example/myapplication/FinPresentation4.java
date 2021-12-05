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
import android.widget.ImageButton;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class FinPresentation4 extends AppCompatActivity {
    private EditText et1=null;
    private EditText et2=null;
    private Button b1=null;
    private Button b2=null;
    private Button b3=null;
    private Button b4=null;
    private Button b5=null;
    boolean log=true;
    private ImageButton ib1=null;
    FirebaseDatabase db;
    DatabaseReference myRef;
    String s1;
    String s2;
    String strkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_presentation4);
        setTitle("Account");
        et1=(EditText) findViewById(R.id.editTextTextPersonName111);
        et2=(EditText) findViewById(R.id.editTextTextPersonName112);
        ib1=(ImageButton) findViewById(R.id.imageButton);
        b1=(Button) findViewById(R.id.button200);
        b2=(Button) findViewById(R.id.button201);
        b3=(Button) findViewById(R.id.button202);
        b4=(Button) findViewById(R.id.button203);
        b5=(Button) findViewById(R.id.button204);
        try {
            Bundle bk = this.getIntent().getExtras();
            strkey = bk.getString("account1");
        }catch (Exception e){

        }
        db=FirebaseDatabase.getInstance();
        myRef=db.getInstance().getReference();
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.getKey().equals(strkey)) {
                    s1=snapshot.child("balance").getValue().toString();
                    s2=snapshot.child("available").getValue().toString();
                    DecimalFormat mDecimalFormat = new DecimalFormat("#,###");
                    double m1=(double)Integer.parseInt(s1);
                    double m2=(double)Integer.parseInt(s2);
                    et1.setText("$$ "+mDecimalFormat.format(m1));
                    et2.setText("$$ "+mDecimalFormat.format(m2));
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


        ib1.setOnClickListener(ibt1);
        et1.setText(s1);
        et2.setText(s2);
        b1.setOnClickListener(bt1);
        b2.setOnClickListener(bt2);
        b3.setOnClickListener(bt3);
        b4.setOnClickListener(bt4);
        b5.setOnClickListener(bt5);
    }
    View.OnClickListener bt1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation4.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i5=new Intent(FinPresentation4.this,FinPresentation.class);
                i5.putExtra("account",strkey);
                setResult(0x123,i5);
                startActivity(i5);
            }

        }
    };

    View.OnClickListener bt2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation4.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                //Intent i2 = new Intent(FinPresentation4.this, FinPresentation4.class);
                //i2.putExtra("account1",account);
                //startActivity(i2);
            }
        }
    };

    View.OnClickListener bt3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation4.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i3 = new Intent(FinPresentation4.this, FinPresentation5.class);
                i3.putExtra("account1",strkey);
                startActivity(i3);
            }
        }
    };

    View.OnClickListener bt4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation4.this,FinPresentation2.class);
                startActivity(i2);
            }else { Intent i3 = new Intent(FinPresentation4.this, FinCards.class);
                i3.putExtra("account1",strkey);
                startActivity(i3); }
        }
    };

    View.OnClickListener bt5=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation4.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i6=new Intent(FinPresentation4.this,FinForyou.class);
                i6.putExtra("account1",strkey);
                startActivity(i6); }
        }
    };



    View.OnClickListener ibt1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder ad=new AlertDialog.Builder(FinPresentation4.this);
            ad.setTitle("Current interest 1.5 percent");
            ad.show();

        }
    };
}