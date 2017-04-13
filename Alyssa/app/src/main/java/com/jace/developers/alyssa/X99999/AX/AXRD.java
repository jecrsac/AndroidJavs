package com.jace.developers.alyssa.X99999.AX;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X87625.X77940;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AXRD extends RecyclerView.Adapter<AXRD.MessageViewHolder> implements View.OnClickListener {

    private Context c;
    private List<X77940> items;
    private View.OnClickListener listener;

    public AXRD(Context context, List<X77940> items) {
        this.items = items;
        c=context;
    }

    @Override
    public AXRD.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dg_itemadapter, parent, false);
        v.setOnClickListener(this);
        return new AXRD.MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AXRD.MessageViewHolder holder, int position) {
        holder.X13100.setText(items.get(position).GXBDC00());
        holder.X13101.setText(items.get(position).GXBDC07());
        //Picasso.with(c).load(items.get(position).GXBDC02()).resize(60, 60).into(holder.X13102);

        Picasso.with(c).load(items.get(position).GXBDC08()).into(holder.X13102);
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
        TextView X13100;
        TextView X13101;
        ImageView X13102;

        MessageViewHolder(View v) {
            super(v);
            X13100 = (TextView) v.findViewById(R.id.SGIX);
            X13101 = (TextView) v.findViewById(R.id.SGNO);
            X13102 = (ImageView) v.findViewById(R.id.SGIC);
        }
    }
}