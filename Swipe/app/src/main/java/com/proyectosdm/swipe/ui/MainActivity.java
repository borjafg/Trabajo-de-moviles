package com.proyectosdm.swipe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.proyectosdm.swipe.R;

public class MainActivity extends AppCompatActivity{

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
        Intent intent = new Intent (this, Tabs.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }

}