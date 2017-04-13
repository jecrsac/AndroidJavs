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
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X99999.CX.CXMN;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SXCL extends AppCompatActivity {

    X86082 XCFG = new X86082();
    HttpURLConnection con;
    String XCH5C5K0C, XIRT0V2P3, XDAT, XHDZ4A59B, XVBEHXCCR;
    String XBN4ENS0E;
    TextView MSG;

    private EditText msg;
    private TextInputLayout input_layout_snmc;


    @SuppressLint({"HardwareIds", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_motivocancel);

        XVBEHXCCR  = Settings.Secure.getString(getApplication().getContentResolver(), Settings.Secure.ANDROID_ID);
        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        XCH5C5K0C = XCFG.GBF00();
        XHDZ4A59B = getIntent().getStringExtra("ACT");

        input_layout_snmc = (TextInputLayout) findViewById(R.id.input_layout_snmc);

        MSG = (TextView) findViewById(R.id.XT7PT0ZFV);

        switch (XHDZ4A59B){
            case "9159353001":
                XBN4ENS0E="8532219200";
                break;
            case "9159353002":
                XBN4ENS0E="9556219000";//Cancelar
                if (MSG != null) {
                    MSG.setText("MOTIVO DE CANCELACIÓN");
                }
                break;
            case "9159353003":
                XBN4ENS0E="9556219001";//No Localizado
                if (MSG != null) {
                    MSG.setText("SINIESTRO NO LOCALIZADO");
                }
                break;
            case "9159353004":
                XBN4ENS0E="9556219002";//Arreglo
                if (MSG != null) {
                    MSG.setText("ACUERDO LLEGADO");
                }
                break;
            case "9159353005":
                XBN4ENS0E="9556219003";//Rechazado
                if (MSG != null) {
                    MSG.setText("MOTIVO DE RECHAZO");
                }
                break;
            default:
                XBN4ENS0E="9999999999";
                break;
        }

        msg = (EditText)findViewById(R.id.XHGQ1SLRY);
        Button b77000 = (Button) findViewById(R.id.XWEANF597);

        msg.addTextChangedListener(new SXCL.MyTextWatcher(msg));

        b77000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

    }



    /** VALIDATING FORM INI ***********************************************************************/
    private Boolean submitForm() {
        if (!validateComment()) {
            return false;
        }

        XIRT0V2P3 = msg.getText().toString();
        try {
            new SXCL.X169184299().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean validateComment() {
        if (msg.getText().toString().trim().isEmpty()) {
            input_layout_snmc.setError(getString(R.string.err_msg_cm));
            requestFocus(msg);
            return false;
        } else {
            input_layout_snmc.setErrorEnabled(false);
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
                case R.id.input_layout_snmc:
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
                String data = URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(XCH5C5K0C, "UTF-8");
                data += "&" + URLEncoder.encode("DS", "UTF-8") + "=" + URLEncoder.encode(XIRT0V2P3, "UTF-8");
                data += "&" + URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode(XBN4ENS0E, "UTF-8");
                data += "&" + URLEncoder.encode("AC", "UTF-8") + "=" + URLEncoder.encode(XHDZ4A59B, "UTF-8");
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
            Intent i = new Intent (SXCL.this, CXMN.class);
            i.putExtra("ACT", XHDZ4A59B);
            startActivity(i);
        }
    }


}
