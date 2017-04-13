package com.jace.developers.alyssa.X99999.AX;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X87625.X77940;

import java.util.List;

public class AXTR extends RecyclerView.Adapter<AXTR.MessageViewHolder> implements View.OnClickListener {

    private List<X77940> items;
    private View.OnClickListener listener;

    public AXTR(List<X77940> items) {
        this.items = items;
    }

    @Override
    public AXTR.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tr_tercerosadapter, parent, false);
        v.setOnClickListener(this);
        return new AXTR.MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AXTR.MessageViewHolder holder, int position) {
        holder.XTDV7TRFX.setText(items.get(position).GXBDC01());
        holder.XTDV7TRNO.setText(items.get(position).GXBDC02());
        holder.XTDV7TRRS.setText(items.get(position).GXBDC04());
        holder.XTDV7TRSG.setText(items.get(position).GXBDC03());
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
        TextView XTDV7TRFX;
        TextView XTDV7TRNO;
        TextView XTDV7TRRS;
        TextView XTDV7TRSG;

        MessageViewHolder(View v) {
            super(v);
            XTDV7TRFX = (TextView) v.findViewById(R.id.XTDV7TRFX);
            XTDV7TRNO = (TextView) v.findViewById(R.id.XTDV7TRNO);
            XTDV7TRRS = (TextView) v.findViewById(R.id.XTDV7TRRS);
            XTDV7TRSG = (TextView) v.findViewById(R.id.XTDV7TRSG);
        }
    }

}
