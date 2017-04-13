package com.jace.developers.alyssa.X99999.UX;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.AX.AXSN;
import com.jace.developers.alyssa.X99999.MX.MXSN;
import com.jace.developers.alyssa.X99999.SX.SXAC;
import com.jace.developers.alyssa.X99999.SX.SXMP;

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


public class UXSN extends Fragment {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(getContext());

    String XDAT, XBIN, XVBEHXCCR;
    HttpURLConnection con;
    ProgressDialog pDialog;

    private RecyclerView recycler;

    public UXSN() {
        // Required empty public constructor
    }




    @SuppressLint("HardwareIds")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }*/

        XCFG = (X86082) getActivity().getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        XBIN = XCFG.GXBIN();/** URL BIN **/
        XVBEHXCCR  = Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.ux_siniestros, container, false);

        // Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.XXL1O6GGC);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        try {
            new X113841615().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return v;
    }



    public class X113841615 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("1266978900", "UTF-8");
                data += "&" + URLEncoder.encode("MV", "UTF-8") + "=" + URLEncoder.encode(XVBEHXCCR, "UTF-8");

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

                int statusCode = con.getResponseCode();

                if(statusCode!=200) {
                    X73698 = new ArrayList<>();
                    X73698.add(new X77940());
                }else{
                    InputStream in = new BufferedInputStream(con.getInputStream());
                    X79141 parser = new X79141();
                    X73698 = parser.X335987082(in);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(con!=null){ con.disconnect(); }
            }

            return X73698;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                final AXSN adaptador = new AXSN(X11287);
                adaptador.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // String XMSG = X11287.get(recycler.getChildAdapterPosition(view)).GXBDC00();
                        // Toast.makeText(getActivity(), "Pulsado el elemento " +XMSG, Toast.LENGTH_SHORT).show();
                        XCFG.SBF00(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC00());/* IX Siniestro */
                        XCFG.SBF01(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC06());/* No Siniestro */
                        XCFG.SBF02(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC07());/* No Poliza */

                        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        switch (X11287.get(recycler.getChildAdapterPosition(view)).GXBDC05()){
                            case "216108305062315"://Trancito
                                Intent i = new Intent (getActivity(), SXMP.class);
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);
                                break;
                            case "516214375419585"://En sitio
                                Intent i2 = new Intent (getActivity(), SXAC.class);
                                startActivity(i2);
                                getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);
                                break;
                            case "116108312486029"://Proceso
                                Intent intent1 = new Intent(getActivity(), MXSN.class);
                                startActivity(intent1);
                                getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);
                                break;
                            case "816108325679284"://Revision
                                builder.setTitle("AVISO")
                                        .setMessage("Siniestro Cerrado")
                                        .setCancelable(false)
                                        .setPositiveButton("ACEPTAR",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                                break;
                            case "416108291784728"://Cancelado
                                builder.setTitle("AVISO")
                                        .setMessage("El siniestro fue cancelado")
                                        .setCancelable(false)
                                        .setPositiveButton("ACEPTAR",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                AlertDialog alertDialogx = builder.create();
                                alertDialogx.show();
                                break;
                            case "316115544452430"://No Localizado
                                builder.setTitle("AVISO")
                                        .setMessage("El siniestro no fue localizado")
                                        .setCancelable(false)
                                        .setPositiveButton("ACEPTAR",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                AlertDialog XBC9AA34X = builder.create();
                                XBC9AA34X.show();
                                break;
                            case "716115550415305"://Arreglo
                                builder.setTitle("AVISO")
                                        .setMessage("Se llego a un acuerdo antes de iniciar el proceso")
                                        .setCancelable(false)
                                        .setPositiveButton("ACEPTAR",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                AlertDialog XM6X98ZJK = builder.create();
                                XM6X98ZJK.show();
                                break;
                            default:
                                Intent i3 = new Intent(getActivity(), MXSN.class);
                                startActivity(i3);
                                getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);
                                break;
                        }
                    }
                });

                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            }else {
                XJCX.showAlertDialog(getContext(),"Alyssa", "- NO SE ENCONTRARON REGISTROS -", false);
            }
        }
    }

}
