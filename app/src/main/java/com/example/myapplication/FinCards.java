package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.KeyEvent;
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

public class FinCards extends AppCompatActivity {
    private EditText et1=null;
    private Button b6=null;
    private ImageButton b7=null;
    private Button b1=null;
    private Button b2=null;
    private Button b3=null;
    private Button b4=null;
    private Button b5=null;
    boolean log=true;
    String strkey;
    int bal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_cards);
        setTitle("Card");
        b6=(Button) findViewById(R.id.button143);
        b7=(ImageButton) findViewById(R.id.imageButton2);
        b1=(Button) findViewById(R.id.button210);
        b2=(Button) findViewById(R.id.button211);
        b3=(Button) findViewById(R.id.button212);
        b4=(Button) findViewById(R.id.button213);
        b5=(Button) findViewById(R.id.button214);
        et1=(EditText) findViewById(R.id.editTextTextPersonName116);
        try {
            Bundle bk = this.getIntent().getExtras();
            strkey = bk.getString("account1");
        }catch (Exception e){

        }
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference myRef=db.getInstance().getReference();
        DecimalFormat mDecimalFormat = new DecimalFormat("#,###");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.getKey().equals(strkey))
                    bal=Integer.parseInt(snapshot.child("balance").getValue().toString());
                double m=(double)bal;
                et1.setText("$$ "+ mDecimalFormat.format(m));
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
        b6.setOnClickListener(bt6);
        b7.setOnClickListener(bt7);
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
                Intent i2=new Intent(FinCards.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i5=new Intent(FinCards.this,FinPresentation.class);
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
                Intent i2=new Intent(FinCards.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i2 = new Intent(FinCards.this, FinPresentation4.class);
                i2.putExtra("account1",strkey);
                startActivity(i2);
            }
        }
    };

    View.OnClickListener bt3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinCards.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i3 = new Intent(FinCards.this, FinPresentation5.class);
                i3.putExtra("account1",strkey);
                startActivity(i3);
            }
        }
    };

    View.OnClickListener bt4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinCards.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                //Intent i3 = new Intent(FinPresentation4.this, FinCards.class);
                //i3.putExtra("account1",strkey);
                //startActivity(i3);
            }
        }
    };

    View.OnClickListener bt5=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinCards.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i6=new Intent(FinCards.this,FinForyou.class);
                i6.putExtra("account1",strkey);
                startActivity(i6);
            }
        }
    };


    View.OnClickListener bt6=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DecimalFormat mDecimalFormat = new DecimalFormat("#,###");
            double m=(double)bal;
            et1.setText("$$ "+ mDecimalFormat.format(m));

        }
    };

    View.OnClickListener bt7=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder ad=new AlertDialog.Builder(FinCards.this);
            ad.setTitle("Coming Soon");
            ad.show();

        }
    };

}