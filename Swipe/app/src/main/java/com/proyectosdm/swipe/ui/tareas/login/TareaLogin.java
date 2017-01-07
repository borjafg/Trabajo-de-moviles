package com.proyectosdm.swipe.ui.tareas.login;

import android.os.AsyncTask;
import android.widget.Toast;

import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.infrastructure.ServiceFactory;
import com.proyectosdm.swipe.model.User;

/**
 * Created by Alberto Cortina on 07/01/2017.
 */

/* Primer parámetro: Tipo de los parámetros que se le pasan antes de ejecutar
 * Segundo parámetro: Tipo de la unidades de progreso del proceso que se ejecute
 * Tercer parámetro: Tipo del objeto que devuelve la tarea
 *
 */
public class TareaLogin extends AsyncTask<TareaLoginParametros, Void, TareaLoginResultado> {

    @Override
    protected TareaLoginResultado doInBackground(TareaLoginParametros... parametros) {
        TareaLoginParametros params = parametros[0];

        params.getMainActivity().ejecutandoTarea = true;

        try{
            User usuario = ServiceFactory.getUserService().login(params.getLogin(), params.getPassword());

            return new TareaLoginResultado(params.getMainActivity(), usuario, "");
        }

        catch(ErrorPeticionException ex) {
            return new TareaLoginResultado(params.getMainActivity(), null, ex.getCausa());
        }
    }

    @Override
    protected void onPostExecute(TareaLoginResultado resultado) {
        resultado.getMainActivity().ejecutandoTarea = false;

        if(resultado.getUser() != null) {
            resultado.getMainActivity().finClickConectarse(resultado.getUser());
        }

        else {
            Toast.makeText(resultado.getMainActivity(), resultado.getCausaError(), Toast.LENGTH_LONG).show();
        }
    }

}