package com.example.practicadefragmentos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TituloFragment extends ListFragment {

    OnTituloSelectedListener mCallback;

    public interface OnTituloSelectedListener{
        public void onTituloSelected(int position);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id){
        mCallback.onTituloSelected(position);
        getListView().setItemChecked(position, true);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            Activity activity = (Activity) context;
            mCallback = (OnTituloSelectedListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+"IMPLEMENTAR OnTituloSelectedListener");
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.fgm_parrafo) != null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(
                new ArrayAdapter<String>(getActivity(),
                        R.layout.support_simple_spinner_dropdown_item,
                        Contenido.titulos));
    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater,
                             ViewGroup viewGroup,
                             Bundle savedInstanceState){

        return layoutInflater.inflate(R.layout.fragment_titulo,
                viewGroup,false);
    }
}
