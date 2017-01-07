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

public class MainActivity extends AppCompatActivity{

    // ---------------------------------------------
    // Evitar Spam en boton login o registrarse
    // ---------------------------------------------

    public Boolean ejecutandoTarea = false;

    // ----------------------------------------------

    Button btn_Abrir_Popup;
    LayoutInflater layoutInflater;
    View popupView;
    PopupWindow popupWindow;
    Button btn_Registrar;
    TextView iniciasesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    iniciasesion= (TextView)findViewById(R.id.tvIniciaSesion);
        btn_Abrir_Popup = (Button)findViewById(R.id.botonregistrarse);
        btn_Abrir_Popup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                layoutInflater =(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                popupView = layoutInflater.inflate(R.layout.pop_registro, null);
                popupWindow = new PopupWindow(popupView, RadioGroup.LayoutParams.MATCH_PARENT,
                        RadioGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setFocusable(true);
                popupWindow.update();

                btn_Registrar = (Button)popupView.findViewById(R.id.botonAceptarRegistro);
                btn_Registrar.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        //Comprobar que las contraseñas coinciden y el usuario no existe en la BD

                        //Guardar los datos en la base de datos


                        popupWindow.dismiss();
                    }});

                popupWindow.showAsDropDown(iniciasesion,0,-130);

            }});
    }

    public void clickConectarse(View view){
        EditText textoLogin = (EditText) findViewById(R.id.textoLogin);
        EditText textoPassword = (EditText) findViewById(R.id.textoPassword);

        if(!ejecutandoTarea) {
            new TareaLogin().execute(new TareaLoginParametros(textoLogin.getText().toString(), textoPassword.getText().toString(), this));
        }
    }

    public void finClickConectarse(User user) {
        Intent intent = new Intent (this, Tabs.class);

        Log.d("Usuario", "Valor del usuario --> " + user.getLogin() + ", " + user.getPassword());
        // Pasar un parcelable (usuario)

        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }

}