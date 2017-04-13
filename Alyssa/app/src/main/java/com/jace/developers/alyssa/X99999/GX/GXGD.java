package com.jace.developers.alyssa.X99999.GX;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.AX.AXGD;

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

public class GXGD extends AppCompatActivity {

    X86082 XCFG = new X86082();

    String XVBEHXCCR, XDAT, IXSN, IXTR, IXAA, IXBB;
    HttpURLConnection con;
    ProgressDialog pDialog;
    TextView RS;

    private RecyclerView recycler;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_guiadeslinde);

        XVBEHXCCR = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        IXTR = XCFG.GBF03();/** IX  TER **/
        IXAA = XCFG.GBF06();/** IX AA **/
        IXBB = XCFG.GBF07();/** IX BB **/


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.XP7K1NFC0);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(GXGD.this);
        recycler.setLayoutManager(lManager);

        RS = (TextView) findViewById(R.id.XW4Q10XUJ);

        try {
            new X121732000().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ImageButton saveGDS = (ImageButton) findViewById(R.id.XIWMCYJXI);
        if (saveGDS != null) {
            saveGDS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        new X169184299().execute(new URL(XDAT));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }


    public class X121732000 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932001", "UTF-8");
                data += "&" + URLEncoder.encode("AA", "UTF-8") + "=" + URLEncoder.encode(IXAA, "UTF-8");
                data += "&" + URLEncoder.encode("BB", "UTF-8") + "=" + URLEncoder.encode(IXBB, "UTF-8");

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
            pDialog = new ProgressDialog(GXGD.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                recycler.setVisibility(View.VISIBLE);
                final AXGD adaptador = new AXGD(getBaseContext(),X11287);
                RS.setText(X11287.get(0).GXBDC03());
                XCFG.SBF08(X11287.get(0).GXBDC03());
                XCFG.SBF15(X11287.get(0).GXBDC04());
                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(GXGD.this,LinearLayoutManager.VERTICAL,false));
            }
        }
    }

    public class X169184299 extends AsyncTask<URL, Void, Void> {
        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("IV", "UTF-8") + "=" + URLEncoder.encode(IXTR, "UTF-8");
                data += "&" + URLEncoder.encode("AA", "UTF-8") + "=" + URLEncoder.encode(IXAA, "UTF-8");
                data += "&" + URLEncoder.encode("BB", "UTF-8") + "=" + URLEncoder.encode(IXBB, "UTF-8");
                data += "&" + URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932002", "UTF-8");

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
            Intent i = new Intent(GXGD.this, GXTX.class);
            startActivity(i);

        }
    }


    @Override
    public void onBackPressed() {  }

}
