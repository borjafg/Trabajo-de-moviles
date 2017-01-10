package com.proyectosdm.beerScanner.ui.tareas.escanear;

import android.app.Service;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.Tabs;

/* Primer parámetro: Tipo de los parámetros que se le pasan antes de ejecutar
 * Segundo parámetro: Tipo de la unidades de progreso del proceso que se ejecute
 * Tercer parámetro: Tipo del objeto que devuelve la tarea
 *
 */
public class TareaEscanear extends AsyncTask<TareaEscanearParametros, Void, TareaEscanearResultado> {

    @Override
    protected TareaEscanearResultado doInBackground(TareaEscanearParametros... parametros) {
        TareaEscanearParametros params = parametros[0];

        ((Tabs) params.getTab_1().getActivity()).ejecutandoTarea = true;

        try {
            Cerveza cerveza = ServiceFactory.getEscanerService().obtenerDatosCerveza(params.getCodigo(), params.getUser());

            return new TareaEscanearResultado(params.getTab_1(), cerveza, "");
        }

        catch(ErrorPeticionException ex) {
            return new TareaEscanearResultado(params.getTab_1(), null, ex.getCausa());
        }
    }

    @Override
    protected void onPostExecute(TareaEscanearResultado resultado) {
        ((Tabs) resultado.getTab_1().getActivity()).ejecutandoTarea = false;

        if(resultado.getCerveza() != null) {
            resultado.getTab_1().finEscanear(resultado.getCerveza());
        }

        else {
            Log.d("Paso por aqui", "La cerveza es null");
            Toast.makeText(resultado.getTab_1().getActivity(), resultado.getCausaError(), Toast.LENGTH_LONG).show();
        }
    }
}