package com.jace.developers.alyssa.X99999.MX;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X99999.DX.AS.XDUA;
import com.jace.developers.alyssa.X99999.DX.CQ.CQCT;
import com.jace.developers.alyssa.X99999.DX.FT.FXCT;
import com.jace.developers.alyssa.X99999.DX.IF.RPCX;
import com.jace.developers.alyssa.X99999.DX.TR.TRLT;

class MXRH extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView countryName;
    ImageView countryPhoto;

    private final Context context;
    private Activity activity;

    MXRH(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        countryName = (TextView)itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);
        activity = (Activity) context;
    }


    @Override
    public void onClick(View view) {
        //Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        Intent i;
        switch (getAdapterPosition()){
            case 0:/** Fotos **/
                i = new Intent(context, FXCT.class);
                context.startActivity(i);
                activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case 1:/** Croquis **/
                i = new Intent(context, CQCT.class);
                context.startActivity(i);
                activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case 3:/** Asegurado **/
                i = new Intent(context, XDUA.class);
                i.putExtra("CXFL","8151323300");
                context.startActivity(i);
                activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case 4:/** Tercero **/
                i = new Intent(context, TRLT.class);
                context.startActivity(i);
                activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case 5:/** Reporte **/
                i = new Intent(context, RPCX.class);
                context.startActivity(i);
                activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            default:
                Toast.makeText(view.getContext(), "- OPCION NO DISPONIBLE -", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
