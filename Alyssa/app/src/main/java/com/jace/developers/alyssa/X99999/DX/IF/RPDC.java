package com.jace.developers.alyssa.X99999.DX.IF;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.AX.AXTR;

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


public class RPDC extends Fragment {

    X86082 XCFG = new X86082();

    String XDAT, XBIN, IXSN, XVBEHXCCR;
    HttpURLConnection con;
    ProgressDialog pDialog;

    TextView X18300, X18301, X18302;
    TextView X18400, X18401, X18402, X18403, X18404, X18405, X18406, X18407, X18408, X18409;
    TextView X18410, X18411, X18412, X18413, X18414, X18415, X18416, X18417;

    private RecyclerView recycler;

    public RPDC() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        XCFG = (X86082) getActivity().getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        XBIN = XCFG.GXBIN();/** URL BIN **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        XVBEHXCCR  = Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.rp_pdf, container, false);

        X18300 = (TextView) v.findViewById(R.id.S13950N);
        X18301 = (TextView) v.findViewById(R.id.S13951N);
        X18302 = (TextView) v.findViewById(R.id.S13952N);

        X18400 = (TextView) v.findViewById(R.id.A13950S);
        X18401 = (TextView) v.findViewById(R.id.A13951S);
        X18402 = (TextView) v.findViewById(R.id.A13952S);
        X18403 = (TextView) v.findViewById(R.id.A13953S);
        X18404 = (TextView) v.findViewById(R.id.A13954S);
        X18405 = (TextView) v.findViewById(R.id.A13955S);
        X18406 = (TextView) v.findViewById(R.id.A13956S);
        X18407 = (TextView) v.findViewById(R.id.A13957S);
        X18408 = (TextView) v.findViewById(R.id.A13958S);
        X18409 = (TextView) v.findViewById(R.id.A13959S);
        X18410 = (TextView) v.findViewById(R.id.A13960S);
        X18411 = (TextView) v.findViewById(R.id.A13961S);
        X18412 = (TextView) v.findViewById(R.id.A13962S);
        X18413 = (TextView) v.findViewById(R.id.A13963S);
        X18414 = (TextView) v.findViewById(R.id.A13964S);
        X18415 = (TextView) v.findViewById(R.id.A13965S);
        X18416 = (TextView) v.findViewById(R.id.A13966S);
        X18417 = (TextView) v.findViewById(R.id.A13967S);

        // Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.XN3BCJ1SY);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        try {
            new X113841615().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            new X114045645().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            new X189193000().execute(new URL(XDAT));
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
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("5035051779", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
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
        protected void onPostExecute(final List<X77940> X11287) {
            if(X11287!=null) {
                X18300.setText(X11287.get(0).GXBDC01());
                X18301.setText(X11287.get(0).GXBDC02());
                X18302.setText(X11287.get(0).GXBDC03());
            }
        }
    }

    /**************************************************************************** SELECT DUA INI **/
    public class X114045645 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("9736036001", "UTF-8");
                data += "&" + URLEncoder.encode("FL", "UTF-8") + "=" + URLEncoder.encode("9333450233", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");

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
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {

                X18400.setText(X11287.get(0).GXBDC28()); //ASEGURADORA
                X18401.setText("DE "+X11287.get(0).GXBDC03()+" A "+X11287.get(0).GXBDC04()); //VIGENCIA
                X18402.setText(X11287.get(0).GXBDC29()); // COBERURA
                X18403.setText(X11287.get(0).GXBDC30()); // COBRANZA
                X18404.setText(X11287.get(0).GXBDC07()+" "+X11287.get(0).GXBDC08()+" "+X11287.get(0).GXBDC09()); // NOMBRE
                X18405.setText(X11287.get(0).GXBDC10()); // TELEFONO

                X18406.setText(X11287.get(0).GXBDC11()+" "+X11287.get(0).GXBDC12()+" "+X11287.get(0).GXBDC13()); // NOMBRE
                X18407.setText(X11287.get(0).GXBDC14()); // EDAD
                X18408.setText(X11287.get(0).GXBDC16()); // TELEFONO
                X18409.setText(X11287.get(0).GXBDC17()); // EMAIL
                X18410.setText(X11287.get(0).GXBDC18()); // TIPO LICENCIA
                X18411.setText("DE "+X11287.get(0).GXBDC19()+" A "+X11287.get(0).GXBDC27()); // VIGENCIA DE

                X18412.setText(X11287.get(0).GXBDC32());
                X18413.setText(X11287.get(0).GXBDC33());
                X18414.setText(X11287.get(0).GXBDC34());
                X18415.setText(X11287.get(0).GXBDC35());
                X18416.setText(X11287.get(0).GXBDC25()); // PLACAS
                X18417.setText(X11287.get(0).GXBDC26()); // SERIE VIN
            }
        }
    }
    /**************************************************************************** SELECT DUA FIN **/

    /************************************************************************ SELECT TERCERO INI **/
    public class X189193000 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932000", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");

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
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                recycler.setVisibility(View.VISIBLE);
                final AXTR adaptador = new AXTR(X11287);
                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            }
        }
    }
    /************************************************************************ SELECT TERCERO FIN **/


}
