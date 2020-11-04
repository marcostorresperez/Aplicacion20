package matope.simarro.aplicacion20.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import matope.simarro.aplicacion20.R;
import matope.simarro.aplicacion20.pojo.Correo;

public class AdaptadorCorreos extends ArrayAdapter<Correo> {
    Activity context;
    ArrayList<Correo> datos;

    public AdaptadorCorreos(Fragment context, ArrayList<Correo> datos) {
        super(context.getActivity(), R.layout.layout_elemento_lista, datos);
        this.context = context.getActivity();
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.layout_elemento_lista, null);
        TextView lblDe = (TextView) item.findViewById(R.id.LblDe);
        lblDe.setText(datos.get(position).getDe());
        TextView lblAsunto = (TextView) item.findViewById(R.id.LblAsunto);
        lblAsunto.setText(datos.get(position).getAsunto());
        return (item);
    }
}