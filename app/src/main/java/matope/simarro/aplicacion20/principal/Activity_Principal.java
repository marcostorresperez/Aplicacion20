package matope.simarro.aplicacion20.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import matope.simarro.aplicacion20.R;
import matope.simarro.aplicacion20.fragment.Activity_Fragment_Detalle;
import matope.simarro.aplicacion20.fragment.Activity_Fragment_Lista;
import matope.simarro.aplicacion20.fragment.CorreosListener;
import matope.simarro.aplicacion20.pojo.Correo;

public class Activity_Principal extends AppCompatActivity implements CorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_principal);

        Activity_Fragment_Lista frgListado = (Activity_Fragment_Lista) getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        frgListado.setCorreosListener(this);
    }

    @Override
    public void onCorreoSeleccionado(Correo c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);
        if (hayDetalle) {
            ((Activity_Fragment_Detalle) getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarDetalle(c.getTexto());
        } else {
            Intent i = new Intent(this, Activity_Detalle.class);
            i.putExtra("TextoDetalle", c.getTexto());
            startActivity(i);
        }
    }
}