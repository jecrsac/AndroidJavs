package com.jace.developers.alyssa.X99999.GX;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class GXRS extends AppCompatActivity {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    String XVBEHXCCR, XDAT, IXSN, IXTR, IXAA, IXBB;
    HttpURLConnection con;
    ProgressDialog pDialog;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_listaresultados);

        XVBEHXCCR = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        IXTR = XCFG.GBF03();/** IX  TER **/
        IXAA = XCFG.GBF06();/** IX AA **/
        IXBB = XCFG.GBF07();/** IX BB **/

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.XFJRT6PW6);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        try {
            new X376482810().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public class X376482810 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932005", "UTF-8");
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
            pDialog = new ProgressDialog(GXRS.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                final AXGN adaptador = new AXGN(GXRS.this,X11287);
                adaptador.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XCFG.SBF09(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC00());/* IX Resultado */
                        XCFG.SBF10(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC05());/* Version Formulario */
                        Intent i = new Intent(GXRS.this, GXTS.class);
                        i.putExtra("ACT", "38017");
                        startActivity(i);
                    }
                });

                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(GXRS.this,LinearLayoutManager.VERTICAL,false));
            }else {
                XJCX.showAlertDialog(GXRS.this,"Alyssa", "- NO SE ENCONTRARON REGISTROS -", false);
            }
        }
    }


}
