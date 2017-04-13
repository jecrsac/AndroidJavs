package com.jace.developers.alyssa.X99999.DX.CQ;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X51827;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class CQRH extends RecyclerView.ViewHolder implements View.OnClickListener{

    private String XBIN, IXSN, ROOT;

    TextView countryName;
    ImageView countryPhoto;

    private final Context context;
    private Activity activity;

    private File file;
    private int tot=0;
    private String[] partsCollArr;
    private String[] xFOTO = null;

    private X99099 XJCX = new X99099(activity);

    CQRH(View itemView, Context context) {
        super(itemView);
        this.context = context;

        X86082 XCFG = (X86082) context.getApplicationContext();
        XBIN = XCFG.GXBIN();/** URL BIN **/
        IXSN = XCFG.GBF00();/** IX  SIN **/

        /** RUTAS **/
        ROOT = XJCX.X165008671()+"/Alyssa/Croquis/"+IXSN+"/";

        itemView.setOnClickListener(this);
        countryName = (TextView) itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);
        activity = (Activity) context;

        File sdDir = new File(ROOT);
        final File[] sdDirFiles = sdDir.listFiles();
        int c=0;

        if (sdDirFiles != null) {
            xFOTO = new String[sdDirFiles.length];
            for(final File singleFile : sdDirFiles) {
                xFOTO[c]= String.valueOf(singleFile);
                c++;
            }
        }


    }


    @Override
    public void onClick(View view) {

        String partsColl = null;
        if (xFOTO != null) { partsColl = xFOTO[getAdapterPosition()]; }
        if (partsColl != null) { partsCollArr = partsColl.split("/"); }
        tot = partsCollArr.length;
        file = new File(ROOT, partsCollArr[tot-1]);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(activity);
        builder1.setMessage("ELIGE UNA ACCION A REALIZAR");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "SUBIR FOTO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        serverUpdate();
                    }
                });

        builder1.setNegativeButton(
                "CANCELAR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    /** # INI FUNCTIONS ######################################################################## **/

    private void serverUpdate(){
        if (file.exists()){ new CQRH.ServerUpdate().execute(); }else{ Toast.makeText(context, "ERROR "+file, Toast.LENGTH_LONG).show(); }
    }

    private class ServerUpdate extends AsyncTask<String,String,String> {

        ProgressDialog pDialog;
        @Override
        protected String doInBackground(String... arg0) {
            uploadFile(ROOT+partsCollArr[tot-1]);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Toast.makeText(context, "Exito al subir la imagen", Toast.LENGTH_LONG).show();
                    XJCX.showAlertDialog(activity,"Alyssa", "EXITO AL SUBIR LA IMAGEN", true);
                }
            });

            return null;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Subiendo Imagen, espere..." );
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pDialog.dismiss();
        }
    }

    private void uploadFile(String filename){
        try {
            FileInputStream fis = new FileInputStream(filename);
            X51827 htfu = new X51827(XBIN+"?CR="+IXSN+"&TP=90892","noparamshere", filename);
            htfu.doStart(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** # FIN FUNCTIONS ######################################################################## **/
}
