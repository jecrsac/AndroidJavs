package com.jace.developers.alyssa.X99999.DG;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.AX.AXGN;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DGTT extends DialogFragment {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(getContext());

    private DGTT.X754277000 mCallback;
    private RecyclerView recycler;

    HttpURLConnection con;
    String XDAT;

    public DGTT() {  }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createLoginDialogo();
    }


    public interface X754277000 {
        void onSelectedTipoTercero(String XG14ESSIX, String XG14ESSNO);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = null;

        if (context instanceof Activity){
            a=(Activity) context;
        }

        try {
            mCallback = (DGTT.X754277000) a;
        } catch (ClassCastException e) {
            Log.d("MyDialog", "Activity doesn't implement the X336801720 interface");
        }

    }

    public AlertDialog createLoginDialogo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.dg_itemlist, null);

        XCFG = (X86082) getActivity().getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/

        try {
            new DGTT.X113841615().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.XNJSL0J39);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        builder.setTitle("TIPO DE TERCERO");
        builder.setCancelable(true);
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        builder.setView(v);

        return builder.create();
    }



    /** TIPO DE TERCERA **/
    public class X113841615 extends AsyncTask<URL, Void, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> XRWW8OPJ6 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("1624811008", "UTF-8");

                con = (HttpURLConnection)urls[0].openConnection();
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setFixedLengthStreamingMode(data.getBytes().length);
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                OutputStream out = new BufferedOutputStream(con.getOutputStream());

                out.write(data.getBytes());
                out.flush();
                out.close();

                //con = (HttpURLConnection)urls[0].openConnection();
                int statusCode = con.getResponseCode();

                if(statusCode!=200) {
                    XRWW8OPJ6 = new ArrayList<>();
                    XRWW8OPJ6.add(new X77940());
                }else{
                    InputStream in = new BufferedInputStream(con.getInputStream());
                    X79141 parser = new X79141();
                    XRWW8OPJ6 = parser.X335987082(in);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(con!=null){ con.disconnect(); }
            }

            return XRWW8OPJ6;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(final List<X77940> XRWW8OPJ6) {
            if(XRWW8OPJ6!=null) {
                final AXGN adaptador = new AXGN(getContext(),XRWW8OPJ6);
                adaptador.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String IXTI = XRWW8OPJ6.get(recycler.getChildAdapterPosition(v)).GXBDC00();
                        String NOTI = XRWW8OPJ6.get(recycler.getChildAdapterPosition(v)).GXBDC01();
                        mCallback.onSelectedTipoTercero(IXTI, NOTI);
                        dismiss();
                    }
                });

                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            }else{
                XJCX.showAlertDialog(getContext(),"Alyssa", "- NO SE ENCONTRARON REGISTROS -", false);
                dismiss();
            }
        }
    }
}
