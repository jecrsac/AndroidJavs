package com.jace.developers.alyssa.X99999.MX;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jace.developers.alyssa.R;

import java.util.List;

class MXRV extends RecyclerView.Adapter<MXRH> {

    private List<MXIT> itemList;
    private Context context;

    MXRV(Context context, List<MXIT> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MXRH onCreateViewHolder(ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mn_items, null);
        return new MXRH(layoutView, context);
    }

    @Override
    public void onBindViewHolder(MXRH holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
