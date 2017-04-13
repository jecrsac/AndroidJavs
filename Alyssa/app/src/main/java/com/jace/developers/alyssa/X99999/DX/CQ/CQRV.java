package com.jace.developers.alyssa.X99999.DX.CQ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jace.developers.alyssa.R;

import java.util.List;

public class CQRV extends RecyclerView.Adapter<CQRH> {

    private List<CQIT> itemList;
    private Context context;

    CQRV(Context context, List<CQIT> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public CQRH onCreateViewHolder(ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mn_items, null);
        return new CQRH(layoutView, context);
    }

    @Override
    public void onBindViewHolder(CQRH holder, @SuppressLint("RecyclerView") final int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageDrawable(itemList.get(position).getPhoto());
        holder.countryPhoto.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
