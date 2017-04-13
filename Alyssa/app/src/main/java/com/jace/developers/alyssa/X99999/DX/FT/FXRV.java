package com.jace.developers.alyssa.X99999.DX.FT;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;

import java.util.List;

class FXRV extends RecyclerView.Adapter<FXRH> {

    private List<FXIT> itemList;
    private Context context;

    FXRV(Context context, List<FXIT> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public FXRH onCreateViewHolder(ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mn_items, null);
        return new FXRH(layoutView, context);
    }

    @Override
    public void onBindViewHolder(FXRH holder, @SuppressLint("RecyclerView") final int position) {
        holder.countryName.setText(itemList.get(position).getName());
        //holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
        holder.countryPhoto.setImageDrawable(itemList.get(position).getPhoto());
        holder.countryPhoto.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
