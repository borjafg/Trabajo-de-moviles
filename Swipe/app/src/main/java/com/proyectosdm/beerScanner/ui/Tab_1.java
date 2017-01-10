package com.proyectosdm.beerScanner.ui;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.ui.tareas.escanear.TareaEscanear;
import com.proyectosdm.beerScanner.ui.tareas.escanear.TareaEscanearParametros;
import com.proyectosdm.beerScanner.ui.tareas.login.TareaLogin;
import com.proyectosdm.beerScanner.ui.tareas.login.TareaLoginParametros;

public class Tab_1 extends Fragment {

    private Button scan_btn;

    public Tab_1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1, container, false);

        scan_btn = (Button) view.findViewById(R.id.scan_button);
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = IntentIntegrator.forSupportFragment(Tab_1.this);

                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Escanea tu cerveza");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.setOrientationLocked(false);

                integrator.initiateScan();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if(result != null){
            if(result.getContents() == null) {
                Toast.makeText(getActivity(), "Has cancelado el escaneo", Toast.LENGTH_LONG).show();
            }

            else {
                empezarEscanear(result.getContents());
            }
        }

        else {
            Log.d("Puede fallar", "Paso por un punto crítico");
            Toast.makeText(getActivity(), "No se han recibido datos", Toast.LENGTH_SHORT).show();
        }
    }

    // ====================================
    // Accion de escaneo
    // ====================================

    public void empezarEscanear(String codigo){
        if(!((Tabs) getActivity()).ejecutandoTarea) {
            if(codigo == null || codigo.equals("")){
                Toast.makeText(getActivity(), "No se ha reconocido el código", Toast.LENGTH_LONG).show();
            }

            else{
                new TareaEscanear().execute(new TareaEscanearParametros(codigo, ((Tabs) getActivity()).getUsuarioLogueado(), this));
            }
        }
    }

    public void finEscanear(Cerveza cerveza) {
        Intent intent = new Intent (getActivity(), InfoCervezaActivity.class);

        intent.putExtra("cerveza", cerveza);

        startActivity(intent);
    }

}