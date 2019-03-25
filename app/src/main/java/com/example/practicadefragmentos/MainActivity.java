package com.example.practicadefragmentos;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListaPaquetesFragments.OnFragmentInteractionListener, DetallePaquetesFragments.OnFragmentInteractionListener, ComunicaFragments{

    ListaPaquetesFragments listaPaquetesFragments;
    DetallePaquetesFragments detallePaquetesFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.contenedorFragment)!=null){
            Utilidades.portatrait=true;
            if(savedInstanceState !=null){
                return;
            }

            listaPaquetesFragments = new ListaPaquetesFragments();

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,listaPaquetesFragments).commit();
        }else{
            Utilidades.portatrait=false;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }

    @Override
    public void enviarPaquete(PaquetesEntidad paquete){
        detallePaquetesFragments=(DetallePaquetesFragments) this.getSupportFragmentManager().findFragmentById(R.id.fragDetalle);

        if(detallePaquetesFragments!=null && findViewById(R.id.contenedorFragment)==null){
            detallePaquetesFragments.asignarInformacion(paquete);
        }else{
            detallePaquetesFragments = new DetallePaquetesFragments();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("objeto",paquete);
            detallePaquetesFragments.setArguments(bundleEnvio);

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,
                    detallePaquetesFragments).addToBackStack(null).commit();

        }
    }
}
