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
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X99999.MX.MXSN;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SXPL extends AppCompatActivity {

    X86082 XCFG = new X86082();

    String XVBEHXCCR, XDAT, IXSN, CXPL, CXCM;
    EditText Placas;
    EditText Coment;
    HttpURLConnection con;

    private TextInputLayout layout_numerplacas, layout_comentarios;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_arriboplacas);

        XVBEHXCCR  = Settings.Secure.getString(getApplication().getContentResolver(), Settings.Secure.ANDROID_ID);
        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();

        layout_numerplacas = (TextInputLayout) findViewById(R.id.layout_numerplacas);
        layout_comentarios = (TextInputLayout) findViewById(R.id.layout_comentarios);

        Button X82810 = (Button) findViewById(R.id.XYS45K0SL);
        Button X82811 = (Button) findViewById(R.id.XYS45K0CN);
        Placas = (EditText) findViewById(R.id.XI8FAK2AW);
        Coment = (EditText) findViewById(R.id.XHGQ1SLRY);

        Placas.addTextChangedListener(new SXPL.MyTextWatcher(Placas));
        Coment.addTextChangedListener(new SXPL.MyTextWatcher(Coment));

        X82810.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        if (X82811 != null) {
            X82811.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CXCM = Coment.getText().toString();
                    CXPL = Placas.getText().toString();
                    try {
                        new X169184299().execute(new URL(XDAT));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    /** VALIDATING FORM INI ***********************************************************************/
    private Boolean submitForm() {
        if (!validateComment()) {
            return false;
        }
        if (!validatePlacas()) {
            return false;
        }

        CXCM = Coment.getText().toString();
        CXPL = Placas.getText().toString();
        try {
            new SXPL.X169184299().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean validateComment() {
        if (Coment.getText().toString().trim().isEmpty()) {
            layout_comentarios.setError(getString(R.string.err_msg_cm));
            requestFocus(Coment);
            return false;
        } else {
            layout_comentarios.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePlacas() {
        if (Placas.getText().toString().trim().isEmpty()) {
            layout_numerplacas.setError(getString(R.string.err_msg_pl));
            requestFocus(Placas);
            return false;
        } else {
            layout_numerplacas.setErrorEnabled(false);
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
                case R.id.layout_numerplacas:
                    validatePlacas();
                    break;
                case R.id.layout_comentarios:
                    validateComment();
                    break;
            }
        }
    }
    /** VALIDATING FORM FIN ***********************************************************************/


    public class X169184299 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("9556219004", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("PL", "UTF-8") + "=" + URLEncoder.encode(CXPL, "UTF-8");
                data += "&" + URLEncoder.encode("CM", "UTF-8") + "=" + URLEncoder.encode(CXCM, "UTF-8");
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

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(con!=null){ con.disconnect(); }
            }

            return null;
        }


        @Override
        protected void onPostExecute(Void s) {
            // Intent i = new Intent (X22300.this, X33000.class);
            Intent i = new Intent (SXPL.this, MXSN.class);
            startActivity(i);
        }
    }




}
