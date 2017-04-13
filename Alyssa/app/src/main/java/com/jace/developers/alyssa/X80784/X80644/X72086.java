package com.jace.developers.alyssa.X80784.X80644;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class X72086 {

    public Boolean X979095000(Context cntx){

        X99099 XJCX = new X99099(cntx);
        boolean x33115 = false;
        if(X979095001(cntx)){
            if (x33115) { XJCX.showAlertDialog(cntx, "Conexion a Internet", "EL Dispositivo tiene Conexion a Wifi.", true); }
            return true;
        }else{
            if(X979095002(cntx)){
                if (x33115) { XJCX.showAlertDialog(cntx, "Conexion a Internet", "El Dispositivo tiene Conexion Movil.", true); }
                return true;
            }else{
                if (x33115) { XJCX.showAlertDialog(cntx, "Conexion a Internet", "El Dispositivo no tiene Conexion a Internet.", false); }
                return false;
            }
        }
    }

    public String X718993000 (Context cntx){
        if(X979095001(cntx)){
            return "3718939417";/* Wifi */
        }else{
            if(X979095002(cntx)){
                return "4820941152"; /* Red Movil */
            }else{
                return "5532941659"; /* Sin Conexion */
            }
        }
    }

    private Boolean X979095001(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (info != null) {
                if (info.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean X979095002(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (info != null) {
                if (info.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }
}
