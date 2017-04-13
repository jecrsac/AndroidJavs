package com.jace.developers.alyssa.X99999.SX;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X86082.X86082;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SXMC extends AppCompatActivity {

    X86082 XCFG = new X86082();
    String IXSN, XDAT;
    HttpURLConnection con;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_menssageconfirm);

        XCFG = (X86082) getApplicationContext();
        IXSN = XCFG.GBF00();
        XDAT = XCFG.GXDAT();/** URL DAT **/

        final String XTGKYFHSN  = XCFG.GBF01();

        TextView X68999 = (TextView) findViewById(R.id.XT46VVF9K);
        if (X68999 != null) {
            X68999.setText(XTGKYFHSN);
        }

        Button boton1 = (Button)findViewById(R.id.XNCXZ5V9R);

        if (boton1 != null) {
            boton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        new X358786300().execute(new URL(XDAT));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    // Intent i = new Intent (SXMC.this, SXMP.class);
                    // startActivity(i);
                }
            });
        }
    }


    /* ARRIBO */
    public class X358786300 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("1266978902", "UTF-8");
                data += "&" + URLEncoder.encode("IX", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");

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
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SXMC.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Void s) {
            Intent i = new Intent (getBaseContext(), SXAC.class);
            startActivity(i);
        }
    }



    @Override
    public void onBackPressed() {  }
}
