package com.jace.developers.alyssa.X99999.GX;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.AX.AXRS;
import com.jace.developers.alyssa.X99999.DX.TR.TRLT;

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

public class GXTS extends AppCompatActivity {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);
    String XDAT, IXSN, IXTR, IXRS, VRFM, RESP, XXPYB94AC;
    String XXPYB94CP;/** Campo **/
    String XXPYB94IS;/** Instancia **/
    HttpURLConnection con;
    ProgressDialog pDialog;
    TextView XW6KK8RPR;
    EditText XW6KK8RRS;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_test);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        IXTR = XCFG.GBF03();/** IX  TER **/
        IXRS = XCFG.GBF09();/** IX  RES **/
        VRFM = XCFG.GBF10();/** Version Form **/

        XXPYB94AC = getIntent().getStringExtra("ACT");/** Actividad **/

        XW6KK8RPR = (TextView) findViewById(R.id.XASVCY2PR);
        XW6KK8RRS = (EditText) findViewById(R.id.XTECXFZG8);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.XD51U5MXF);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        ImageButton X82646 = (ImageButton) findViewById(R.id.XU8QGOYDS);

        try {
            new X899400555().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (X82646 != null) {
            X82646.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RESP = XW6KK8RRS.getText().toString();

                    try {
                        new X488108221().execute(new URL(XDAT));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public class X899400555 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932006", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("IV", "UTF-8") + "=" + URLEncoder.encode(IXTR, "UTF-8");
                data += "&" + URLEncoder.encode("RS", "UTF-8") + "=" + URLEncoder.encode(IXRS, "UTF-8");
                data += "&" + URLEncoder.encode("MF", "UTF-8") + "=" + URLEncoder.encode(VRFM, "UTF-8");

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
                int TTPR = X11287.size();
                XCFG.SBF12(Integer.toString(TTPR));
                if (!XXPYB94AC.equals("14912")){
                    int pos = (Integer.parseInt(XCFG.GBF11()));
                    if(pos==0){
                        XCFG.SBF13(X11287.get(0).GXBDC05());/* Instancia */
                    }
                }
                XCFG.SBF14(X11287.get(Integer.parseInt(XCFG.GBF11())).GXBDC03());/* Campo */
                XW6KK8RPR.setText(X11287.get(Integer.parseInt(XCFG.GBF11())).GXBDC02());

                XXPYB94CP = XCFG.GBF14();
                XXPYB94IS = XCFG.GBF13();

                try {
                    new X376482810().execute(new URL(XDAT));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class X376482810 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932007", "UTF-8");
                data += "&" + URLEncoder.encode("IS", "UTF-8") + "=" + URLEncoder.encode(XXPYB94IS, "UTF-8");
                data += "&" + URLEncoder.encode("MF", "UTF-8") + "=" + URLEncoder.encode(VRFM, "UTF-8");

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
            pDialog = new ProgressDialog(GXTS.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                final AXRS adaptador = new AXRS(X11287);
                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(GXTS.this,LinearLayoutManager.VERTICAL,false));
            }
        }
    }

    public class X488108221 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("CP", "UTF-8") + "=" + URLEncoder.encode(XXPYB94CP, "UTF-8");
                data += "&" + URLEncoder.encode("IS", "UTF-8") + "=" + URLEncoder.encode(XXPYB94IS, "UTF-8");
                data += "&" + URLEncoder.encode("RP", "UTF-8") + "=" + URLEncoder.encode(RESP, "UTF-8");
                data += "&" + URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932008", "UTF-8");

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

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(con!=null){ con.disconnect(); }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void s) {
            int pos = (Integer.parseInt(XCFG.GBF11())+1);
            int tot = (Integer.parseInt(XCFG.GBF12()));
            if (pos < tot){
                XCFG.SBF11(Integer.toString(pos));
                Intent i = new Intent(GXTS.this, GXTS.class);
                i.putExtra("ACT", "38017");
                startActivity(i);
            }else{
                //Toast.makeText(GXTS.this, "Final", Toast.LENGTH_SHORT).show();
                XCFG.SBF11("0");
                Intent i = new Intent(GXTS.this, TRLT.class);
                startActivity(i);
            }
        }
    }
}
