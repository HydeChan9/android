package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FinForyou extends AppCompatActivity {
    boolean log=true;
    private Button b1=null;
    private Button b2=null;
    private Button b3=null;
    private Button b4=null;
    private Button b5=null;
    private WebView wv1=null;
    String strkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_foryou);
        b1=(Button) findViewById(R.id.button215);
        b2=(Button) findViewById(R.id.button216);
        b3=(Button) findViewById(R.id.button217);
        b4=(Button) findViewById(R.id.button218);
        b5=(Button) findViewById(R.id.button219);
        setTitle("For you");
        wv1=(WebView) findViewById(R.id.Webview5);
        wv1.loadUrl("https://www.commbank.com.au/");

        try {
            Bundle bk = this.getIntent().getExtras();
            strkey = bk.getString("account1");
        }catch (Exception e){
        }
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference myRef=db.getInstance().getReference();
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.getKey().equals(strkey)) {
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
                Intent i2=new Intent(FinForyou.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i5=new Intent(FinForyou.this,FinPresentation.class);
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
                Intent i2=new Intent(FinForyou.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i2 = new Intent(FinForyou.this, FinPresentation4.class);
                i2.putExtra("account1",strkey);
                startActivity(i2);
            }
        }
    };

    View.OnClickListener bt3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinForyou.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i3 = new Intent(FinForyou.this, FinPresentation5.class);
                i3.putExtra("account1",strkey);
                startActivity(i3);
            }
        }
    };

    View.OnClickListener bt4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinForyou.this,FinPresentation2.class);
                startActivity(i2);
            }else { Intent i3 = new Intent(FinForyou.this, FinCards.class);
                i3.putExtra("account1",strkey);
                startActivity(i3); }
        }
    };

    View.OnClickListener bt5=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinForyou.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                //Intent i6=new Intent(FinPresentation4.this,FinForyou.class);
                // startActivity(i6);
            }
        }
    };

}