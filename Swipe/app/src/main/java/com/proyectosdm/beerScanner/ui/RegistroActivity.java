package com.proyectosdm.beerScanner.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.tareas.registro.TareaRegistro;
import com.proyectosdm.beerScanner.ui.tareas.registro.TareaRegistroParametros;

public class RegistroActivity extends AppCompatActivity {

    // ---------------------------------------------
    // Evitar Spam en boton registrarse
    // ---------------------------------------------
    public Boolean ejecutandoTarea = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_activity);
    }

    @Override
    public void onBackPressed() {
    }

    public void cancelarAccion(View view) {
        this.finish();
    }

    // ====================================
    // Accion de registro
    // ====================================

    public void registrarse(View view) {
        if (!ejecutandoTarea) {
            String nombre = ((EditText) findViewById(R.id.registroNombre)).getText().toString();
            String login = ((EditText) findViewById(R.id.registroUsuario)).getText().toString();
            String password = ((EditText) findViewById(R.id.registroContraseña)).getText().toString();

            if (nombre.equals("") || login.equals("") || password.equals("")) {
                Toast.makeText(this, "Ningún campo puede estar vacío", Toast.LENGTH_LONG).show();
            } else {
                new TareaRegistro().execute(new TareaRegistroParametros(nombre, login, password, this));
            }
        }
    }

    public void finClickRegistrarse(User user) {
        Toast.makeText(this, "Registro completo, inicie sesión", Toast.LENGTH_LONG).show();
        this.finish();
    }
}
