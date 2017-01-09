package com.proyectosdm.beerScanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.tareas.login.TareaLogin;
import com.proyectosdm.beerScanner.ui.tareas.login.TareaLoginParametros;

public class LoginActivity extends AppCompatActivity{

    // ---------------------------------------------
    // Evitar Spam en boton login
    // ---------------------------------------------

    public Boolean ejecutandoTarea = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    public void onBackPressed() {
    }

    public void registrarse(View view) {
        EditText textoLogin = (EditText) findViewById(R.id.textoLogin);
        EditText textoPassword = (EditText) findViewById(R.id.textoPassword);
        textoLogin.setText("");
        textoPassword.setText("");

        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    // ====================================
    // Accion de login
    // ====================================

    public void clickConectarse(View view){
        if(!ejecutandoTarea) {
            String textoLogin = ((EditText) findViewById(R.id.textoLogin)).getText().toString();
            String textoPassword = ((EditText) findViewById(R.id.textoPassword)).getText().toString();

            if(textoLogin.equals("") || textoPassword.equals("")){
                Toast.makeText(this, "No se ha indicado el usuario o la contraseña", Toast.LENGTH_LONG).show();
            }

            else{
                new TareaLogin().execute(new TareaLoginParametros(textoLogin, textoPassword, this));
            }
        }
    }

    public void finClickConectarse(User user) {
        ((EditText) findViewById(R.id.textoLogin)).setText("");
        ((EditText) findViewById(R.id.textoPassword)).setText("");

        Intent intent = new Intent (this, Tabs.class);

        intent.putExtra("usuario",user);

        startActivity(intent);
    }
}