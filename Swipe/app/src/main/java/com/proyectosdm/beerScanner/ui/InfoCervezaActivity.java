package com.proyectosdm.beerScanner.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.Cerveza;

public class InfoCervezaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_cerveza_activity);

        Cerveza cerveza = getIntent().getParcelableExtra("cerveza");

        mostrarInformacion(cerveza);
    }

    @Override
    public void onBackPressed() {
    }

    private void mostrarInformacion(Cerveza cerveza) {
        ((TextView) findViewById(R.id.nombreResultado)).setText(cerveza.getNombre());
        ((TextView) findViewById(R.id.descripcionResultado)).setText(cerveza.getDescripcion());
        ((TextView) findViewById(R.id.graduacionResultado)).setText(String.valueOf(cerveza.getGraduacion()) + "%");
        ((TextView) findViewById(R.id.maltaResultado)).setText(cerveza.getMalta());
        ((TextView) findViewById(R.id.lupuloResultado)).setText(cerveza.getLupulo());
        ((TextView) findViewById(R.id.estiloResultado)).setText(cerveza.getEstilo());
    }

    public void atras(View view) {
        this.finish();
    }
}