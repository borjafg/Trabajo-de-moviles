package com.proyectosdm.beerScanner.ui.tareas.historial;

import android.os.AsyncTask;
import android.widget.Toast;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.ui.Tabs;

import java.util.List;

public class TareaHistorial extends AsyncTask<TareaHistorialParametros, Void, TareaHistorialResultado> {

    @Override
    protected TareaHistorialResultado doInBackground(TareaHistorialParametros... parametros) {
        TareaHistorialParametros params = parametros[0];

        ((Tabs) params.getTab_2().getActivity()).ejecutandoTarea = true;

        try {
            List<Cerveza> listaCervezas = ServiceFactory.getHistorialService().obtenerHistorial(params.getUser());

            return new TareaHistorialResultado(params.getTab_2(), listaCervezas, "");
        } catch (ErrorPeticionException ex) {
            return new TareaHistorialResultado(params.getTab_2(), null, ex.getCausa());
        }
    }

    @Override
    protected void onPostExecute(TareaHistorialResultado resultado) {
        ((Tabs) resultado.getTab_2().getActivity()).ejecutandoTarea = false;

        if (resultado.getListaCervezas() != null) {
            resultado.getTab_2().setListaCervezas(resultado.getListaCervezas());
        } else {
            Toast.makeText(resultado.getTab_2().getActivity(), resultado.getCausaError(), Toast.LENGTH_LONG).show();
        }
    }
}