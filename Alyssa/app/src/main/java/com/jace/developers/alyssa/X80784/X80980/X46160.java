package com.jace.developers.alyssa.X80784.X80980;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.jace.developers.alyssa.X80784.X80644.X72086;


public class X46160 extends BroadcastReceiver {

    X72086 XCNX = new X72086();

    @Override
    public void onReceive(Context context, Intent intent) {

        if(XCNX.X979095000(context)){
            //Toast.makeText(context, "CBX - Canal Activo", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(context, "CBX - No Signal", Toast.LENGTH_SHORT).show();
        }
    }
}
