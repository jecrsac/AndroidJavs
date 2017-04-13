package com.jace.developers.alyssa.X99999.GX;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;

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

public class GXTX extends AppCompatActivity {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    String XDAT, TXGD;
    HttpURLConnection con;
    TextView GuiaText;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_guiadeslindetexto);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        TXGD = XCFG.GBF15();/** TXT Guia Deslinde **/

        Button X41330 = (Button) findViewById(R.id.XRQCFHJ0A);
        Button X41331 = (Button) findViewById(R.id.XRQCFHJ0B);
        Button X41332 = (Button) findViewById(R.id.XRQCFHJ0C);

        GuiaText = (TextView) findViewById(R.id.XQZY4VN1I);

        try {
            new GuiaDeslinde().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (X41330 != null) { /** Regresar **/
            X41330.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(GXTX.this, GXGD.class);
                    startActivity(i);
                }
            });
        }

        if (X41331 != null) { /** Modificar **/
            X41331.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(GXTX.this, GXMD.class);
                    startActivity(i);
                }
            });
        }

        if (X41332 != null) { /** Continuar **/
            X41332.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(GXTX.this, GXRS.class);
                    startActivity(i);
                }
            });
        }


    }


    public class GuiaDeslinde extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932003", "UTF-8");
                data += "&" + URLEncoder.encode("GDTX", "UTF-8") + "=" + URLEncoder.encode(TXGD, "UTF-8");

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
            pDialog = new ProgressDialog(GXTX.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                GuiaText.setText(X11287.get(0).GXBDC01());
            }else{
                XJCX.showAlertDialog(GXTX.this,"Alyssa", "- NO SE ENCONTRARON COINCIDENCIAS -", false);
            }
        }
    }


    @Override
    public void onBackPressed() {  }

}
