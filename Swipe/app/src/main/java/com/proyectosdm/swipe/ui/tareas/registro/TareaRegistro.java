package com.proyectosdm.swipe.ui.tareas.registro;

import android.os.AsyncTask;
import android.widget.Toast;

import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.infrastructure.ServiceFactory;
import com.proyectosdm.swipe.model.User;

public class TareaRegistro extends AsyncTask<TareaRegistroParametros, Void, TareaRegistroResultado> {

    @Override
    protected TareaRegistroResultado doInBackground(TareaRegistroParametros... parametros) {
        TareaRegistroParametros params = parametros[0];

        params.getMainActivity().ejecutandoTarea = true;

        try{
            User usuario = new User(params.getLogin(), params.getPassword(), params.getNombre());

            ServiceFactory.getUserService().registrarse(usuario);

            return new TareaRegistroResultado(params.getMainActivity(), usuario, "");
        }

        catch(ErrorPeticionException ex) {
            return new TareaRegistroResultado(params.getMainActivity(), null, ex.getCausa());
        }
    }

    @Override
    protected void onPostExecute(TareaRegistroResultado resultado) {
        resultado.getMainActivity().ejecutandoTarea = false;

        if(resultado.getUser() != null) {
            resultado.getMainActivity().finClickRegistrarse(resultado.getUser());
        }

        else {
            Toast.makeText(resultado.getMainActivity(), resultado.getCausaError(), Toast.LENGTH_LONG).show();
        }
    }
}
