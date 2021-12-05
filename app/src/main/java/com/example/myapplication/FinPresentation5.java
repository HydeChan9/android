package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;

public class FinPresentation5 extends AppCompatActivity {
    private EditText et1=null;
    private EditText et2=null;
    private EditText et3=null;
    private Button b1=null;
    private Button b2=null;
    private Button b3=null;
    private Button b4=null;
    private Button b5=null;
    private Button b6=null;
    private Spinner s1=null;
    private String strkey;
    private String depositacc;
    private String e2;
    private int total;
    private int total2;
    boolean log=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_presentation5);
        setTitle("Transfer");
        et1=(EditText) findViewById(R.id.editTextTextPersonName113);
        et2=(EditText) findViewById(R.id.editTextTextPersonName114);
        et3=(EditText) findViewById(R.id.editTextTextPersonName115);
        b6=(Button) findViewById(R.id.button141);
        s1=(Spinner) findViewById(R.id.spinner6);
        b1=(Button) findViewById(R.id.button205);
        b2=(Button) findViewById(R.id.button206);
        b3=(Button) findViewById(R.id.button207);
        b4=(Button) findViewById(R.id.button208);
        b5=(Button) findViewById(R.id.button209);
        try {
            Bundle bk = this.getIntent().getExtras();
            strkey = bk.getString("account1");
        }catch (Exception e){

        }
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference myRef=db.getInstance().getReference();
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.getKey()!="") {
                    if (snapshot.getKey().equals(strkey)){

                    }else
                        aa.add(snapshot.getKey());
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

        // String[] key=strkey.split(" ");

        //  for (int i=0;i<key.length;i++){
        //     aa.add(key);
        //}
        s1.setAdapter(aa);
        s1.setOnItemSelectedListener(spli);

        b6.setOnClickListener(bt6);
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
                Intent i2=new Intent(FinPresentation5.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i5=new Intent(FinPresentation5.this,FinPresentation.class);
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
                Intent i2=new Intent(FinPresentation5.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i2 = new Intent(FinPresentation5.this, FinPresentation4.class);
                i2.putExtra("account1",strkey);
                startActivity(i2);
            }
        }
    };

    View.OnClickListener bt3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation5.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                //Intent i3 = new Intent(FinPresentation5.this, FinPresentation5.class);
                // i3.putExtra("account1",strkey);
                //startActivity(i3);
            }
        }
    };

    View.OnClickListener bt4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation5.this,FinPresentation2.class);
                startActivity(i2);
            }else { Intent i3 = new Intent(FinPresentation5.this, FinCards.class);
                i3.putExtra("account1",strkey);
                startActivity(i3); }
        }
    };

    View.OnClickListener bt5=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation5.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i6=new Intent(FinPresentation5.this,FinForyou.class);
                i6.putExtra("account1",strkey);
                startActivity(i6);
            }
        }
    };

    View.OnClickListener bt6=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference myRef = db.getInstance().getReference();
            if (Integer.parseInt(et3.getText().toString())<0){
                AlertDialog.Builder ad1=new AlertDialog.Builder(FinPresentation5.this);
                ad1.setTitle("incorrect amount");
                ad1.show();

            }else if(total<=0||Integer.parseInt(et3.getText().toString())>total){
                AlertDialog.Builder ad2=new AlertDialog.Builder(FinPresentation5.this);
                ad2.setTitle("Not enough balance");
                ad2.show();

            }else {
                myRef.child(strkey).child("balance").setValue(total - Integer.parseInt(et3.getText().toString()));
                myRef.child(depositacc).child("balance").setValue(total2 + Integer.parseInt(et3.getText().toString()));
                AlertDialog.Builder ad = new AlertDialog.Builder(FinPresentation5.this);
                ad.setTitle("transfer success");
                ad.show();
                DecimalFormat mDecimalFormat = new DecimalFormat("#,###");
                et2.setText("$$ "+mDecimalFormat.format((double) (total- Integer.parseInt(et3.getText().toString()))));
            }
        }
    };


    AdapterView.OnItemSelectedListener spli=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            depositacc=adapterView.getItemAtPosition(i).toString().trim();
            FirebaseDatabase db=FirebaseDatabase.getInstance();
            DatabaseReference myRef=db.getInstance().getReference();
            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    if (snapshot.getKey().equals(strkey)){
                        total=Integer.parseInt(snapshot.child("balance").getValue().toString());
                        DecimalFormat mDecimalFormat = new DecimalFormat("#,###");
                        et2.setText("$$ "+mDecimalFormat.format((double) total));
                        et1.setText(strkey);
                    }
                    if (snapshot.getKey().equals(depositacc)){
                        total2=Integer.parseInt(snapshot.child("balance").getValue().toString());
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

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

}