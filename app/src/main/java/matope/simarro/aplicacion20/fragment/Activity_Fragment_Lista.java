package matope.simarro.aplicacion20.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import matope.simarro.aplicacion20.R;
import matope.simarro.aplicacion20.adaptador.AdaptadorCorreos;
import matope.simarro.aplicacion20.pojo.Correo;

public class Activity_Fragment_Lista extends Fragment {
    private ArrayList<Correo> datos = new ArrayList<Correo>();
    private ListView lstListado;
    private CorreosListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_lista, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        lstListado = (ListView) getView().findViewById(R.id.LstListado);
        datos.add(new Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"));
        datos.add(new Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"));
        datos.add(new Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"));
        datos.add(new Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"));
        datos.add(new Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5"));
        lstListado.setAdapter(new AdaptadorCorreos(this, datos));

        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
                if (listener != null) {
                    listener.onCorreoSeleccionado(
                            (Correo) lstListado.getAdapter().getItem(pos));
                }
            }
        });
    }

    public void setCorreosListener(CorreosListener listener) {
        this.listener = listener;
    }
}