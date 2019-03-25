package com.example.practicadefragmentos;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadoresPaquetes extends RecyclerView.Adapter<AdaptadoresPaquetes.PaquetesViewHolder> implements View.OnClickListener{

    ArrayList<PaquetesEntidad> listaPaquetes;
    private View.OnClickListener listener;
    public AdaptadoresPaquetes(ArrayList<PaquetesEntidad> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;

    }

    @NonNull
    @Override
    public PaquetesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        view.setOnClickListener(this);
        return new PaquetesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaquetesViewHolder holder, int position) {
        holder.txtNombre.setText(listaPaquetes.get(position).getNombre());
        if(Utilidades.portatrait==true){
            holder.txtInformacion.setText(listaPaquetes.get(position).getInfo());
        }


        holder.foto.setImageResource(listaPaquetes.get(position).getImagenID());
    }

    @Override
    public int getItemCount() {
        return listaPaquetes.size();
    }
    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class PaquetesViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre,txtInformacion;
        ImageView foto;

        public PaquetesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre=(TextView) itemView.findViewById(R.id.idNombre);
            if(Utilidades.portatrait==true){
                txtInformacion=(TextView) itemView.findViewById(R.id.idInfo);
            }

            foto=(ImageView) itemView.findViewById(R.id.idImagen);

        }
    }
}
