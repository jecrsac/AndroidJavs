package com.jace.developers.alyssa.X99999.AX;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X87625.X77940;

import java.util.List;

public class AXRS extends RecyclerView.Adapter<AXRS.MessageViewHolder> implements View.OnClickListener {

    private List<X77940> items;
    private View.OnClickListener listener;

    public AXRS(List<X77940> items) {
        this.items = items;
    }

    @Override
    public AXRS.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gd_testadapter, parent, false);
        v.setOnClickListener(this);
        return new AXRS.MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AXRS.MessageViewHolder holder, int position) {
        holder.XIF71YHRS.setText(items.get(position).GXBDC02());
        //holder.XIF71YHFC.setText(items.get(position).GXBDC01());
        holder.XIF71YHPR.setText(items.get(position).GXBDC01());
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
        TextView XIF71YHRS;
        TextView XIF71YHFC;
        TextView XIF71YHPR;

        MessageViewHolder(View v) {
            super(v);
            XIF71YHRS = (TextView) v.findViewById(R.id.XIF71YHRS);
            XIF71YHFC = (TextView) v.findViewById(R.id.XIF71YHFC);
            XIF71YHPR = (TextView) v.findViewById(R.id.XIF71YHPR);
        }
    }

}
