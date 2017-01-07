package com.proyectosdm.swipe.ui;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.proyectosdm.swipe.R;

public class Tab_1 extends Fragment {

    private Button scan_btn;
    private TextView resultado;

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

        resultado = (TextView) view.findViewById(R.id.tvCodigo);

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
                Toast.makeText(getActivity(), result.getContents(), Toast.LENGTH_LONG).show();
                resultado.setText(result.getContents());
            }
        }

        else {
            Log.d("Puede fallar", "Paso por un punto crítico");
            Toast.makeText(getActivity(), "No se han recibido datos", Toast.LENGTH_SHORT).show();
        }
    }

}