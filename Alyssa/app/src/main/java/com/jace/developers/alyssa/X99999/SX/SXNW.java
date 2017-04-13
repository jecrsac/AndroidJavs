package com.jace.developers.alyssa.X99999.SX;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SXNW extends AppCompatActivity {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    private EditText SN;
    private EditText AS;
    private EditText PO;

    String XVBEHXCCR, XDAT;
    String D12800, D12801, D12802, IXSN;

    HttpURLConnection con;

    private TextInputLayout input_layout_snnu, input_layout_snas, input_layout_snpo;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_nuevo);

        XVBEHXCCR  = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XJCX.xAKN("DKN");

        input_layout_snnu = (TextInputLayout) findViewById(R.id.input_layout_snnu);
        input_layout_snas = (TextInputLayout) findViewById(R.id.input_layout_snas);
        input_layout_snpo = (TextInputLayout) findViewById(R.id.input_layout_snpo);

        SN = (EditText) findViewById(R.id.R99100);
        AS = (EditText) findViewById(R.id.R99200);
        PO = (EditText) findViewById(R.id.R99300);

        Button b77000 = (Button) findViewById(R.id.R99400);

        SN.addTextChangedListener(new SXNW.MyTextWatcher(SN));
        AS.addTextChangedListener(new SXNW.MyTextWatcher(AS));
        PO.addTextChangedListener(new SXNW.MyTextWatcher(PO));

        b77000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

    }


    /** VALIDATING FORM INI ***********************************************************************/
    private Boolean submitForm() {
        if (!validateSiniestro()) {
            return false;
        }

        if (!validateAsegurado()) {
            return false;
        }

        if (!validatePoliza()) {
            return false;
        }

        D12800 = SN.getText().toString();
        D12801 = AS.getText().toString();
        D12802 = PO.getText().toString();

        try {
            new SXNW.X169184299().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean validateSiniestro() {
        if (SN.getText().toString().trim().isEmpty()) {
            input_layout_snnu.setError(getString(R.string.err_msg_sn));
            requestFocus(SN);
            return false;
        } else {
            input_layout_snnu.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAsegurado() {
        if (AS.getText().toString().trim().isEmpty()) {
            input_layout_snas.setError(getString(R.string.err_msg_as));
            requestFocus(AS);
            return false;
        } else {
            input_layout_snas.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePoliza() {
        if (PO.getText().toString().trim().isEmpty()) {
            input_layout_snpo.setError(getString(R.string.err_msg_as));
            requestFocus(PO);
            return false;
        } else {
            input_layout_snpo.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_layout_snnu:
                    validateSiniestro();
                    break;
                case R.id.input_layout_snas:
                    validateAsegurado();
                    break;
                case R.id.input_layout_snpo:
                    validatePoliza();
                    break;
            }
        }
    }
    /** VALIDATING FORM FIN ***********************************************************************/


    /** INSERT SINIESTRO INI **********************************************************************/
    public class X169184299 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            XCFG.SBF00(IXSN);
            XCFG.SBF01(D12800);
            XCFG.SBF02(D12802);

            try {
                String data = URLEncoder.encode("IX", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(D12800, "UTF-8");
                data += "&" + URLEncoder.encode("AS", "UTF-8") + "=" + URLEncoder.encode(D12801, "UTF-8");
                data += "&" + URLEncoder.encode("PO", "UTF-8") + "=" + URLEncoder.encode(D12802, "UTF-8");
                data += "&" + URLEncoder.encode("MV", "UTF-8") + "=" + URLEncoder.encode(XVBEHXCCR, "UTF-8");
                data += "&" + URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("1266978901", "UTF-8");

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

            String XP3243XRT = XJCX.X165008671()+"/Alyssa/Croquis/"+IXSN+"/";
            XJCX.X165008670("/Alyssa/Croquis/"+IXSN+"/");
            String nomarchivo = ".Nomedia";
            File file = new File(XP3243XRT, nomarchivo);
            FileOutputStream out;
            try {
                out = new FileOutputStream(file);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String XP3243XFT = XJCX.X165008671()+"/Alyssa/Fotos/"+IXSN+"/";
            XJCX.X165008670("/Alyssa/Fotos/"+IXSN+"/");
            XJCX.X165008670("/Alyssa/Fotos/"+IXSN+"/thumbnail/");
            String archivo = ".Nomedia";
            File file_foto = new File(XP3243XFT, archivo);
            FileOutputStream outstr;
            try {
                outstr = new FileOutputStream(file_foto);
                outstr.flush();
                outstr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Intent i = new Intent(SXNW.this, SXMC.class);
            startActivity(i);
        }
    }

    /** INSERT SINIESTRO FIN **********************************************************************/

}
