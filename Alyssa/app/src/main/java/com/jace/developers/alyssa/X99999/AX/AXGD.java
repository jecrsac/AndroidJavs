package com.jace.developers.alyssa.X99999.AX;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X99999.GX.GXGD;

import java.util.List;

import static java.security.AccessController.getContext;

public class AXGD extends RecyclerView.Adapter<AXGD.MessageViewHolder> implements View.OnClickListener {

    private List<X77940> items;
    private View.OnClickListener listener;
    private Context c;


    public AXGD(Context context, List<X77940> items) {
        c=context;
        this.items = items;
    }

    @Override
    public AXGD.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gd_guiadeslindeadapter, parent, false);
        v.setOnClickListener(this);
        return new AXGD.MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AXGD.MessageViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        final X86082 XCFG = (X86082) c.getApplicationContext();
        final String XTGKYPOSA = XCFG.GBF04();/* Posicion A */
        final String XTGKYPOSB = XCFG.GBF05();/* Posicion B */

        holder.res_txt.setText(items.get(position).GXBDC02());


        holder.rdbA.setChecked(position == Integer.parseInt(XTGKYPOSA));
        holder.rdbA.setTag(position);
        holder.rdbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XCFG.SBF04(Integer.toString(position));
                XCFG.SBF06(items.get(position).GXBDC00());/* IX GDA */
                notifyDataSetChanged();
                Intent i = new Intent(c, GXGD.class);
                view.getContext().startActivity(i);
            }
        });


        holder.rdbB.setChecked(position == Integer.parseInt(XTGKYPOSB));
        holder.rdbB.setTag(position);
        holder.rdbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XCFG.SBF05(Integer.toString(position));
                XCFG.SBF07(items.get(position).GXBDC00());/* IX GDB */
                notifyDataSetChanged();
                Intent i = new Intent(c, GXGD.class);
                view.getContext().startActivity(i);
            }
        });

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
        TextView res_txt;
        RadioButton rdbA;
        RadioButton rdbB;

        MessageViewHolder(View v) {
            super(v);
            res_txt = (TextView) v.findViewById(R.id.res_txt);
            rdbA = (RadioButton) v.findViewById(R.id.rdbA);
            rdbB = (RadioButton) v.findViewById(R.id.rdbB);
        }
    }

}
