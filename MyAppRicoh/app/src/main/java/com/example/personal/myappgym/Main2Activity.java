package com.example.personal.myappgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button btn_bd;
    private Button btn_datos;
    private Button btn_fit;
    private Button btn_cardio;
    private Button btn_rv;
    private Button btn_inst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_bd = findViewById(R.id.btn_bd);
        btn_datos = findViewById(R.id.btn_datos);
        btn_fit = findViewById(R.id.btn_fit);
        btn_cardio = findViewById(R.id.btn_cardio);
        btn_rv = findViewById(R.id.btn_rv);
        btn_inst = findViewById(R.id.btn_inst);
//
        btn_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        //
        //
        btn_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
        //
        //
        btn_fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, Main5Activity.class);
                startActivity(intent);
            }
        });
        //
        //
        btn_cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, Main6Activity.class);
                startActivity(intent);
            }
        });
        //
        //
        btn_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, Main7Activity.class);
                startActivity(intent);
            }
        });
        //
        //
        btn_inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, Main8Activity.class);
                startActivity(intent);
            }
        });
        //
    }

        //INICIO MENU
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //MENU DE OPCIONES GENERAL FRAME
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            //NAVEGAR A OTRO MAINACTIVITY
            case R.id.itebd:
                Intent intent = new Intent( this, Main3Activity.class);
                intent.putExtra("abc", 10);
                startActivity(intent);
                break;
            case R.id.itead:
                Intent intent2 = new Intent( this, Main4Activity.class);
                intent2.putExtra("abc", 10);
                startActivity(intent2);
                break;
            case R.id.iteft:
                Intent intent3 = new Intent( this, Main5Activity.class);
                intent3.putExtra("abc", 10);
                startActivity(intent3);
                break;
            case R.id.itecd:
                Intent intent4 = new Intent( this, Main6Activity.class);
                intent4.putExtra("abc", 10);
                startActivity(intent4);
                break;
            case R.id.iterv:
                Intent intent5 = new Intent( this, Main7Activity.class);
                intent5.putExtra("abc", 10);
                startActivity(intent5);
                break;
            case R.id.iteinst:
                Intent intent6 = new Intent( this, Main8Activity.class);
                intent6.putExtra("abc", 10);
                startActivity(intent6);
                break;
            case R.id.iteabout:
                Intent intent7 = new Intent( this, Main9Activity.class);
                intent7.putExtra("abc", 10);
                startActivity(intent7);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    }

