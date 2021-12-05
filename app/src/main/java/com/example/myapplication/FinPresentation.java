package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;
import java.util.zip.Inflater;

public class FinPresentation extends AppCompatActivity {
    private MenuInflater mi=null;
    private Button b1=null;
    private Button b2=null;
    private Button b3=null;
    private Button b4=null;
    private Button b5=null;
    private Button b6=null;
    String account="empty";
    boolean log=false;


    //from finall
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==0x123);
        account= getIntent().getStringExtra("account");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mi=getMenuInflater();
        mi.inflate(R.menu.finmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.a1:{
                if (log==false){
                    Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                    startActivity(i2);
                }else {
                    Intent i2 = new Intent(FinPresentation.this, FinPresentation4.class);
                    i2.putExtra("account1",account);
                    startActivity(i2);
                }
                break;
            }
            case R.id.a2:{
                if (log==false){
                    Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                    startActivity(i2);
                }else {
                    Intent i3 = new Intent(FinPresentation.this, FinPresentation5.class);
                    i3.putExtra("account1",account);
                    startActivityForResult(i3,0x123);
                }
                break;
            }

            case R.id.a4:{
                if (log==false){
                    Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                    startActivity(i2);
                }else {
                    //profile
                    Intent i4=new Intent();
                }
                break;
            }
            case R.id.a5:{
                account="";
                log=false;
                AlertDialog.Builder ad2=new AlertDialog.Builder(FinPresentation.this);
                ad2.setTitle("Thank you for banking with us");
                ad2.show();
                break;
            }
            case R.id.i1:{
                if (log==false){
                    Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                    startActivity(i2);
                }else { }
                break;
            }
            case R.id.i2:{
                if (log==false){
                    Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                    startActivity(i2);
                }
                break;
            }
            case R.id.i3:{
                if (log==false){
                    Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                    startActivity(i2);
                }else{ log=true;
                }
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_presentation);
        setTitle("Hello,");
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        b1=(Button) findViewById(R.id.button94);
        b2=(Button) findViewById(R.id.button95);
        b3=(Button) findViewById(R.id.button96);
        b4=(Button) findViewById(R.id.button97);
        b5=(Button) findViewById(R.id.button98);
        b6=(Button) findViewById(R.id.button99);
        //from fin2-login
        try {
            Bundle bk = this.getIntent().getExtras();
            account = bk.getString("account");
        }catch (Exception e){

        }
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference myRef=db.getInstance().getReference();
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if (dataSnapshot.getKey().equals(account)){
                    log=true;
                    account=dataSnapshot.getKey();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        b1.setOnClickListener(bt1);
        b2.setOnClickListener(bt2);
        b3.setOnClickListener(bt3);
        b4.setOnClickListener(bt4);
        b5.setOnClickListener(bt5);
        b6.setOnClickListener(bt6);




    }

    View.OnClickListener bt1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                //Intent i5=new Intent(FinPresentation.this,FinPresentation.class);
                //startActivity(i5);
            }

        }
    };

    View.OnClickListener bt2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i2 = new Intent(FinPresentation.this, FinPresentation4.class);
                i2.putExtra("account1",account);
                startActivity(i2);
            }
        }
    };

    View.OnClickListener bt3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i3 = new Intent(FinPresentation.this, FinPresentation5.class);
                i3.putExtra("account1",account);
                startActivity(i3);
            }
        }
    };

    View.OnClickListener bt4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                startActivity(i2);
            }else { Intent i3 = new Intent(FinPresentation.this, FinCards.class);
                i3.putExtra("account1",account);
                startActivity(i3); }
        }
    };

    View.OnClickListener bt5=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log==false){
                Intent i2=new Intent(FinPresentation.this,FinPresentation2.class);
                startActivity(i2);
            }else {
                Intent i6=new Intent(FinPresentation.this,FinForyou.class);
                i6.putExtra("account1",account);
                startActivity(i6);
            }
        }
    };

    View.OnClickListener bt6=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (log == false) {
                Intent i1 = new Intent(FinPresentation.this, FinPresentation2.class);
                startActivity(i1);
            } else { }
        }
    };
}