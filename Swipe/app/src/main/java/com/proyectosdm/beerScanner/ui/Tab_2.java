package com.proyectosdm.beerScanner.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.proyectosdm.beerScanner.R;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.ui.tareas.historial.TareaHistorial;
import com.proyectosdm.beerScanner.ui.tareas.historial.TareaHistorialParametros;
import com.proyectosdm.beerScanner.ui.tareas.sugerencia.TareaSugerencia;
import com.proyectosdm.beerScanner.ui.tareas.sugerencia.TareaSugerenciaParametros;

import java.util.ArrayList;
import java.util.List;

public class Tab_2 extends Fragment {

    private List<String> cervezas;
    private ArrayAdapter<String> adaptador;
    private static List<Cerveza> listaCervezas;
    private static View view;

    public Tab_2() {
    }

    public static List<Cerveza> getListaCervezas() {
        return listaCervezas;
    }

    public static View getVista() {
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_2, container, false);

        final ListView lv = (ListView) view.findViewById(R.id.lista);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                int itemPosition = position;

                String itemValue = (String) lv.getItemAtPosition(position);

                Cerveza cerveza = null;
                for(Cerveza c: listaCervezas){
                    if(c.getNombre().equals(itemValue)){
                        cerveza = c;
                        break;
                    }
                }

                Intent intent = new Intent (getActivity(), InfoCervezaActivity.class);

                intent.putExtra("cerveza", cerveza);

                startActivity(intent);
            }
        });
        return view;
    }

    // ====================================
    // Accion de mostrarHistorial
    // ====================================
    public void clickHistorial() {
        if(!((Tabs) getActivity()).ejecutandoTarea) {
            new TareaHistorial().execute(new TareaHistorialParametros(((Tabs) getActivity()).getUsuarioLogueado(), this));
        }
    }

    public void setListaCervezas(List<Cerveza> listaCervezas) {
        this.listaCervezas = listaCervezas;

        cervezas = new ArrayList<String>();
        for(Cerveza c: listaCervezas){
            cervezas.add(c.getNombre());
        }

        adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cervezas);
        ListView lv = (ListView) view.findViewById(R.id.lista);
        lv.setAdapter(adaptador);
    }
}
