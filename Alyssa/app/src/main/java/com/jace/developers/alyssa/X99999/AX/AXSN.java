package com.jace.developers.alyssa.X99999.AX;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X87625.X77940;

import java.util.List;

public class AXSN extends RecyclerView.Adapter<AXSN.MessageViewHolder> implements View.OnClickListener {

    private List<X77940> items;
    private View.OnClickListener listener;

    public AXSN(List<X77940> items) {
        this.items = items;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.us_listasiniestros, parent, false);
        v.setOnClickListener(this);
        return new MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.fecha.setText(items.get(position).GXBDC04());
        holder.titulo.setText(items.get(position).GXBDC01());
        holder.clave.setText(items.get(position).GXBDC03());
        holder.estatus.setText(items.get(position).GXBDC02  ());
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }



    static class MessageViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        TextView fecha;
        TextView titulo;
        TextView clave;
        TextView estatus;

        MessageViewHolder(View v) {
            super(v);
            fecha = (TextView) v.findViewById(R.id.fecha);
            titulo = (TextView) v.findViewById(R.id.titulo);
            clave = (TextView) v.findViewById(R.id.clave);
            estatus = (TextView) v.findViewById(R.id.estatus);
        }
    }

}
