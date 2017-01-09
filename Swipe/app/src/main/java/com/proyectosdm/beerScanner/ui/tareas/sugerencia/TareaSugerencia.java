package com.proyectosdm.beerScanner.ui.tareas.sugerencia;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.Tabs;
import com.proyectosdm.beerScanner.ui.tareas.sugerencia.TareaSugerenciaParametros;
import com.proyectosdm.beerScanner.ui.tareas.sugerencia.TareaSugerenciaResultado;

/* Primer parámetro: Tipo de los parámetros que se le pasan antes de ejecutar
 * Segundo parámetro: Tipo de la unidades de progreso del proceso que se ejecute
 * Tercer parámetro: Tipo del objeto que devuelve la tarea
 *
 */
public class TareaSugerencia extends AsyncTask<TareaSugerenciaParametros, Void, TareaSugerenciaResultado> {

    @Override
    protected TareaSugerenciaResultado doInBackground(TareaSugerenciaParametros... parametros) {
        TareaSugerenciaParametros params = parametros[0];

        ((Tabs) params.getTab_1().getActivity()).ejecutandoTarea = true;

        try {
            Cerveza cerveza = ServiceFactory.getSugerenciaService().obtenerSugerencia(params.getUser());

            return new TareaSugerenciaResultado(params.getTab_1(), cerveza, "");
        } catch (ErrorPeticionException ex) {
            return new TareaSugerenciaResultado(params.getTab_1(), null, ex.getCausa());
        }
    }

    @Override
    protected void onPostExecute(TareaSugerenciaResultado resultado) {
        ((Tabs) resultado.getTab_1().getActivity()).ejecutandoTarea = false;

        if (resultado.getCerveza() != null) {
            resultado.getTab_1().finSugerencia(resultado.getCerveza());
        } else {
            Toast.makeText(resultado.getTab_1().getActivity(), resultado.getCausaError(), Toast.LENGTH_LONG).show();
        }
    }
}