package com.proyectosdm.swipe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.proyectosdm.swipe.R;
import com.proyectosdm.swipe.model.User;

public class MainActivity extends AppCompatActivity{

    Button btn_Abrir_Popup;
    LayoutInflater layoutInflater;
    LayoutInflater layoutInflater2;
    View popupView;
    View popupView2;
    PopupWindow popupWindow;
    PopupWindow popupWindow2;
    Button btn_Registrar;
    Button btn_cancelar;
    TextView iniciasesion;
    Button botonConectar;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    iniciasesion= (TextView)findViewById(R.id.tvIniciaSesion);
        btn_Abrir_Popup = (Button)findViewById(R.id.botonregistrarse);
        botonConectar= (Button)findViewById(R.id.botonconectarse);
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
                btn_cancelar= (Button)popupView.findViewById(R.id.buttonCancelarVentanaRegstro);
                btn_Registrar.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        //Comprobar que las contraseñas coinciden y el usuario no existe en la BD


                        //Guardar los datos en la base de datos

                    }});

                btn_cancelar.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        popupWindow.dismiss();
                    }});
                popupWindow.showAsDropDown(iniciasesion,0,-130);

            }});
    }

    public void clickConectarse(View view){
        EditText usuario= (EditText) findViewById(R.id.editTextNombreDeUsuario);
        EditText contraseña= (EditText) findViewById(R.id.editTextContraseña);

        if(usuario.getText().toString().equals("")||contraseña.getText().toString().equals(""))
        {
            mostrarError("El usuario o la contraseña son incorrectos");
        }
        else{

        user= new User(((EditText)findViewById(R.id.editTextNombreDeUsuario)).getText().toString(),((EditText)findViewById(R.id.editTextContraseña)).getText().toString(),((EditText)findViewById(R.id.editTextNombreDeUsuario)).getText().toString());

        Intent intent = new Intent (this, Tabs.class);
        startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {

    }

    public void mostrarError(String mensaje)
    {
        layoutInflater =(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = layoutInflater.inflate(R.layout.error_entrada_campos, null);
        popupWindow = new PopupWindow(popupView, RadioGroup.LayoutParams.MATCH_PARENT,RadioGroup.LayoutParams.WRAP_CONTENT);
        ((TextView)findViewById(R.id.textViewError)).setText(mensaje);
        popupWindow.setFocusable(true);
        popupWindow.update();

        Button btn_cancelar= (Button)popupView.findViewById(R.id.buttonCancelarError);
        btn_cancelar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }});
        popupWindow.showAsDropDown((Button)findViewById(R.id.botonAceptarRegistro),100,-250);
    }

}