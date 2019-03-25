package com.example.practicadefragmentos;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaPaquetesFragments extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ArrayList<PaquetesEntidad> listaPaquetes;
    RecyclerView recyclerPaquetes;

    Activity activity;
    ComunicaFragments interfaceComunicaFragments;


    public ListaPaquetesFragments() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListaPaquetesFragments newInstance(String param1, String param2) {
        ListaPaquetesFragments fragment = new ListaPaquetesFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_lista_paquetes, container, false);

        listaPaquetes = new ArrayList<>();
        recyclerPaquetes =(RecyclerView) vista.findViewById(R.id.recyclerid);
        recyclerPaquetes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaPaquetes();
        AdaptadoresPaquetes adapter = new AdaptadoresPaquetes(listaPaquetes);
        recyclerPaquetes.setAdapter(adapter);

        adapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Selecciona: "+listaPaquetes.get(recyclerPaquetes.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
                interfaceComunicaFragments.enviarPaquete(listaPaquetes.get(recyclerPaquetes.getChildAdapterPosition(view)));
            }


        });
        return vista;
    }

    private void llenarListaPaquetes() {

        listaPaquetes.add(new PaquetesEntidad(getString(R.string.paquete01),getString(R.string.paquete01_descripcionc),getString(R.string.paquete01_descripcionl),R.drawable.paquete1,R.drawable.paquete1_detalle));
        listaPaquetes.add(new PaquetesEntidad(getString(R.string.paquete02),getString(R.string.paquete02_descripcionc),getString(R.string.paquete02_descripcionl),R.drawable.paquete2,R.drawable.paquete2_detalle));
        listaPaquetes.add(new PaquetesEntidad(getString(R.string.paquete03),getString(R.string.paquete03_descripcionc),getString(R.string.paquete03_descripcionl),R.drawable.paquete3,R.drawable.paquete3_detalle));
        listaPaquetes.add(new PaquetesEntidad(getString(R.string.paquete04),getString(R.string.paquete04_descripcionc),getString(R.string.paquete04_descripcionl),R.drawable.paquete4,R.drawable.paquete4_detalle));
        listaPaquetes.add(new PaquetesEntidad(getString(R.string.paquete05),getString(R.string.paquete05_descripcionc),getString(R.string.paquete05_descripcionl),R.drawable.paquete5,R.drawable.paquete5_detalle));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  Activity){
            this.activity=(Activity) context;
            interfaceComunicaFragments=(ComunicaFragments) this.activity;
        }

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
