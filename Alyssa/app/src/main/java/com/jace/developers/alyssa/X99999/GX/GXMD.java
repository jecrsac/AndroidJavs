package com.jace.developers.alyssa.X99999.GX;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X86082.X86082;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class GXMD extends AppCompatActivity {

    X86082 XCFG = new X86082();

    String XDAT, IXSN, IXTR;
    HttpURLConnection con;
    String X12840, X12841, RESP;
    EditText X25962;
    Spinner X18160;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_modificar);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        IXTR = XCFG.GBF03();/** IX  TER **/

        TextView X30663 = (TextView) findViewById(R.id.XAI1L4A1H);
        X25962 = (EditText) findViewById(R.id.XZRTC4K8Y);
        X18160 = (Spinner) findViewById(R.id.XABJTMWL8);
        Button X38400 = (Button) findViewById(R.id.XGD5SQ16E);

        if (X30663 != null) {
            RESP ="Responsabilidad "+XCFG.GBF08();
            X30663.setText(RESP);
        }

        if (X18160 != null) {
            X18160.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    X12840 = parentView.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }
            });
        }

        if (X38400 != null) {
            X38400.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    X12841 = X25962.getText().toString();
                    if (X12840.trim().equalsIgnoreCase("--") || X12841.trim().equalsIgnoreCase("")) {
                        Toast.makeText(GXMD.this, "Hay informacion por rellenar", Toast.LENGTH_LONG).show();
                    }else{
                        try {
                            new X169184299().execute(new URL(XDAT));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }


    public class X169184299 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("IV", "UTF-8") + "=" + URLEncoder.encode(IXTR, "UTF-8");
                data += "&" + URLEncoder.encode("RA", "UTF-8") + "=" + URLEncoder.encode(X12840, "UTF-8");
                data += "&" + URLEncoder.encode("RC", "UTF-8") + "=" + URLEncoder.encode(X12841, "UTF-8");
                data += "&" + URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932004", "UTF-8");

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
            Intent i = new Intent(GXMD.this, GXRS.class);
            startActivity(i);
        }
    }


}
