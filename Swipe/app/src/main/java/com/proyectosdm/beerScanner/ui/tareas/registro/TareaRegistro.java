package com.proyectosdm.beerScanner.ui.tareas.registro;

import android.os.AsyncTask;
import android.widget.Toast;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.User;

public class TareaRegistro extends AsyncTask<TareaRegistroParametros, Void, TareaRegistroResultado> {

    @Override
    protected TareaRegistroResultado doInBackground(TareaRegistroParametros... parametros) {
        TareaRegistroParametros params = parametros[0];

        params.getRegistroActivity().ejecutandoTarea = true;

        try {
            User usuario = new User(params.getLogin(), params.getPassword(), params.getNombre());

            ServiceFactory.getUserService().registrarse(usuario);

            return new TareaRegistroResultado(params.getRegistroActivity(), usuario, "");
        } catch (ErrorPeticionException ex) {
            return new TareaRegistroResultado(params.getRegistroActivity(), null, ex.getCausa());
        }
    }

    @Override
    protected void onPostExecute(TareaRegistroResultado resultado) {
        resultado.getRegistroActivity().ejecutandoTarea = false;

        if (resultado.getUser() != null) {
            resultado.getRegistroActivity().finClickRegistrarse(resultado.getUser());
        } else {
            Toast.makeText(resultado.getRegistroActivity(), resultado.getCausaError(), Toast.LENGTH_LONG).show();
        }
    }
}
