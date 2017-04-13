package com.jace.developers.alyssa.X99999.DX.TR;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X99999.MX.MXSN;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class TRFR extends AppCompatActivity {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    String XVBEHXCCR, XDAT, IXSN, TPNO, TPIX, IXTR;
    String XCMC00, XCMC01, XCMC02, XCMC03, XCMC04;
    EditText NO, DN;
    CheckBox CK1, CK2, CK3;
    HttpURLConnection con = null;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tr_formulario);

        XVBEHXCCR = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        IXTR = XJCX.xAKN("DKN");/** IX TER **/

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TPNO = (String) extras.get("TPNO");
            TPIX = (String) extras.get("TPIX");
        }

        setTitle(TPNO);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);

        NO = (EditText) findViewById(R.id.TRBN);
        DN = (EditText) findViewById(R.id.TRDN);
        CK1 = (CheckBox) findViewById(R.id.PGVL);
        CK2 = (CheckBox) findViewById(R.id.PGPG);
        CK3 = (CheckBox) findViewById(R.id.PGEF);

        Button SAVE = (Button) findViewById(R.id.TRSV);
        if (SAVE != null) {
            SAVE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    XCMC00 = NO.getText().toString();
                    XCMC01 = DN.getText().toString();
                    XCMC02 = (CK1.isChecked() ? "VOLANTE DE ADMISION" : "");
                    XCMC03 = (CK2.isChecked() ? "PRONTO PAGO" : "");
                    XCMC04 = (CK3.isChecked() ? "EFECTIVO" : "");

                    XCFG.SBF03(IXTR);/** IX Tercero **/
                    ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                    if (networkInfo != null && networkInfo.isConnected()) {
                        try {
                            new X169184100().execute(new URL(XDAT));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }else{
                        XJCX.showAlertDialog(TRFR.this,"Alyssa", "ERROR DE CONEXION", true);
                    }
                }
            });
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case android.R.id.home:
                i = new Intent(TRFR.this, TRLT.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public class X169184100 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("XBDC00", "UTF-8") + "=" + URLEncoder.encode(XCMC00, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC01", "UTF-8") + "=" + URLEncoder.encode(XCMC01, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC02", "UTF-8") + "=" + URLEncoder.encode(XCMC02, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC03", "UTF-8") + "=" + URLEncoder.encode(XCMC03, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC04", "UTF-8") + "=" + URLEncoder.encode(XCMC04, "UTF-8");
                data += "&" + URLEncoder.encode("TP", "UTF-8") + "=" + URLEncoder.encode(TPIX, "UTF-8");
                data += "&" + URLEncoder.encode("TR", "UTF-8") + "=" + URLEncoder.encode(IXTR, "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("FL", "UTF-8") + "=" + URLEncoder.encode("9333450233", "UTF-8");
                data += "&" + URLEncoder.encode("AC", "UTF-8") + "=" + URLEncoder.encode("1189487001", "UTF-8");
                data += "&" + URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("9736036000", "UTF-8");

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
            Intent i = new Intent(TRFR.this, TRLT.class);
            startActivity(i);
        }
    }


}
