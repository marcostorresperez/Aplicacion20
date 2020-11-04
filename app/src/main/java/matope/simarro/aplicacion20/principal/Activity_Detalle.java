package matope.simarro.aplicacion20.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import matope.simarro.aplicacion20.R;
import matope.simarro.aplicacion20.fragment.Activity_Fragment_Detalle;

public class Activity_Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_detalle);

        Activity_Fragment_Detalle detalle =
                (Activity_Fragment_Detalle) getSupportFragmentManager()
                        .findFragmentById(R.id.FrgDetalle);
        detalle.mostrarDetalle(getIntent().getStringExtra("TextoDetalle"));
    }
}