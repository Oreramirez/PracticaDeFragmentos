package com.example.practicadefragmentos;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TituloFragment.OnTituloSelectedListener{

    private final int[] BOTONESILUMINADOS={R.drawable.paquete1, R.drawable.paquete2, R.drawable.paquete3, R.drawable.paquete4, R.drawable.paquete5,
            R.drawable.fondo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) !=null){
            if (savedInstanceState !=null){
                return;
            }
            TituloFragment tituloFragment = new TituloFragment();

            tituloFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container,
                            tituloFragment)
                    .commit();
        }
    }

    @Override
    public void onTituloSelected(int position) {
        ParrafoFragment parrafoFragment = (ParrafoFragment)getSupportFragmentManager().findFragmentById(R.id.fgm_parrafo);

        if(parrafoFragment != null){
            parrafoFragment.updateParrafoView(position);

        } else {
            ParrafoFragment parrafoFragment1 = new ParrafoFragment();
            Bundle args = new Bundle();
            args.putInt(ParrafoFragment.ARG_POSITION,position);

            parrafoFragment1.setArguments(args);

            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();


            fragmentTransaction.replace(R.id.fragment_container,parrafoFragment1);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }


}
