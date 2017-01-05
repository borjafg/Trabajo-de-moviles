package com.proyectosdm.swipe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.proyectosdm.swipe.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    public void onBackPressed() {
        //No hacer nada al pulsar botón atrás
    }

    public void pasarPantalla(View view){
        Intent intent = new Intent (this, Tabs.class);
        startActivity(intent) ;
    }
}
