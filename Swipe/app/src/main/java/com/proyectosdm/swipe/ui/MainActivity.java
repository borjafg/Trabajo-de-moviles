package com.proyectosdm.swipe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.proyectosdm.swipe.R;
import com.proyectosdm.swipe.model.User;
import com.proyectosdm.swipe.ui.tareas.login.TareaLogin;
import com.proyectosdm.swipe.ui.tareas.login.TareaLoginParametros;
import com.proyectosdm.swipe.ui.tareas.registro.TareaRegistro;
import com.proyectosdm.swipe.ui.tareas.registro.TareaRegistroParametros;

public class MainActivity extends AppCompatActivity{

    // ---------------------------------------------
    // Evitar Spam en boton login o registrarse
    // ---------------------------------------------

    public Boolean ejecutandoTarea = false;

    // ----------------------------------------------

    LayoutInflater layoutInflater;
    View popupView;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final TextView iniciasesion= (TextView)findViewById(R.id.tvIniciaSesion);
        Button btn_Abrir_Popup = (Button)findViewById(R.id.botonregistrarse);
        btn_Abrir_Popup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                layoutInflater =(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                popupView = layoutInflater.inflate(R.layout.pop_registro, null);
                popupWindow = new PopupWindow(popupView, RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setFocusable(true);
                popupWindow.update();

                Button btn_Registrar = (Button) popupView.findViewById(R.id.botonAceptarRegistro);
                btn_Registrar.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        clickRegistrarse(v);
                    }});

                Button btn_cancelar = (Button) popupView.findViewById(R.id.botonCancelarRegistro);
                btn_cancelar.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }});

                popupWindow.showAsDropDown(iniciasesion,0,-130);

            }});
    }

    @Override
    public void onBackPressed() {

    }

    // ====================================
    // Accion de login
    // ====================================

    public void clickConectarse(View view){
        String textoLogin = ((EditText) findViewById(R.id.textoLogin)).getText().toString();
        String textoPassword = ((EditText) findViewById(R.id.textoPassword)).getText().toString();

        if(!ejecutandoTarea) {
            new TareaLogin().execute(new TareaLoginParametros(textoLogin, textoPassword, this));
        }
    }

    public void finClickConectarse(User user) {
        Intent intent = new Intent (this, Tabs.class);

        Log.d("Usuario", "Valor del usuario --> " + user.getLogin() + ", " + user.getPassword());
        // Pasar un parcelable (usuario)

        startActivity(intent);
    }

    // ====================================
    // Accion de registro
    // ====================================
    public void clickRegistrarse(View view){
        String textoNombre = ((EditText) findViewById(R.id.registroNombre)).getText().toString();
        String textoLogin = ((EditText) findViewById(R.id.registroUsuario)).getText().toString();
        String textoPassword = ((EditText) findViewById(R.id.registroContraseña)).getText().toString();

        if(!ejecutandoTarea) {
            new TareaRegistro().execute(new TareaRegistroParametros(textoNombre, textoLogin, textoPassword, this));
        }
    }
    public void finClickRegistrarse(User user) {
        Intent intent = new Intent (this, Tabs.class);

        Log.d("Usuario", "Valor del usuario --> " + user.getLogin() + ", " + user.getPassword());
        // Pasar un parcelable (usuario)

        startActivity(intent);
    }
}