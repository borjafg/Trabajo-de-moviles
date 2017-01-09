package com.proyectosdm.beerScanner.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.tareas.escanear.TareaEscanear;
import com.proyectosdm.beerScanner.ui.tareas.escanear.TareaEscanearParametros;
import com.proyectosdm.beerScanner.ui.tareas.sugerencia.TareaSugerencia;
import com.proyectosdm.beerScanner.ui.tareas.sugerencia.TareaSugerenciaParametros;

public class Tab_1 extends Fragment {

    private Button scan_btn;
    private int firstTouchX;
    private int firstTouchY;

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

        Button bt_sugerencia = (Button) view.findViewById(R.id.bt_sugerencia);
        bt_sugerencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSugerencia();
            }
        });

       view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        firstTouchX = (int) event.getX();
                        firstTouchY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (firstTouchX > event.getX()) {
                            Tabs.getTab_2().clickHistorial();
                        }
                        break;
                }
                return true;
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(getActivity(), "Has cancelado el escaneo", Toast.LENGTH_LONG).show();
            } else {
                empezarEscanear(result.getContents());
            }
        } else {
            Toast.makeText(getActivity(), "No se han recibido datos", Toast.LENGTH_SHORT).show();
        }
    }

    // ====================================
    // Accion de escaneo
    // ====================================

    public void empezarEscanear(String codigo) {
        if (!((Tabs) getActivity()).ejecutandoTarea) {
            if (codigo == null || codigo.equals("")) {
                Toast.makeText(getActivity(), "No se ha reconocido el código", Toast.LENGTH_LONG).show();
            } else {
                new TareaEscanear().execute(new TareaEscanearParametros(codigo, ((Tabs) getActivity()).getUsuarioLogueado(), this));
            }
        }
    }

    public void finEscanear(Cerveza cerveza) {
        Intent intent = new Intent(getActivity(), InfoCervezaActivity.class);

        intent.putExtra("cerveza", cerveza);

        startActivity(intent);
    }

    // ====================================
    // Accion de sugerencia
    // ====================================

    public void clickSugerencia() {
        if (!((Tabs) getActivity()).ejecutandoTarea) {
            new TareaSugerencia().execute(new TareaSugerenciaParametros(((Tabs) getActivity()).getUsuarioLogueado(), this));
        }
    }

    public void finSugerencia(Cerveza cerveza) {
        Intent intent = new Intent(getActivity(), InfoCervezaActivity.class);

        intent.putExtra("cerveza", cerveza);

        startActivity(intent);
    }
}