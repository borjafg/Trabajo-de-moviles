package com.proyectosdm.beerScanner.ui.tareas.login;

import android.os.AsyncTask;
import android.widget.Toast;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.User;

/* Primer parámetro: Tipo de los parámetros que se le pasan antes de ejecutar
 * Segundo parámetro: Tipo de la unidades de progreso del proceso que se ejecute
 * Tercer parámetro: Tipo del objeto que devuelve la tarea
 *
 */
public class TareaLogin extends AsyncTask<TareaLoginParametros, Void, TareaLoginResultado> {

    @Override
    protected TareaLoginResultado doInBackground(TareaLoginParametros... parametros) {
        TareaLoginParametros params = parametros[0];

        params.getLoginActivity().ejecutandoTarea = true;

        try{
            User usuario = ServiceFactory.getUserService().login(params.getLogin(), params.getPassword());

            return new TareaLoginResultado(params.getLoginActivity(), usuario, "");
        }

        catch(ErrorPeticionException ex) {
            return new TareaLoginResultado(params.getLoginActivity(), null, ex.getCausa());
        }
    }

    @Override
    protected void onPostExecute(TareaLoginResultado resultado) {
        resultado.getLoginActivity().ejecutandoTarea = false;

        if(resultado.getUser() != null) {
            resultado.getLoginActivity().finClickConectarse(resultado.getUser());
        }

        else {
            Toast.makeText(resultado.getLoginActivity(), resultado.getCausaError(), Toast.LENGTH_LONG).show();
        }
    }
}