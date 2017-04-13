package com.jace.developers.alyssa.X99999.DX.AS;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.DG.DGCB;
import com.jace.developers.alyssa.X99999.DG.DGCO;
import com.jace.developers.alyssa.X99999.DG.DGMD;
import com.jace.developers.alyssa.X99999.DG.DGMR;
import com.jace.developers.alyssa.X99999.DG.DGSG;
import com.jace.developers.alyssa.X99999.DG.DGTP;
import com.jace.developers.alyssa.X99999.DG.DGUS;
import com.jace.developers.alyssa.X99999.DG.DGVA;
import com.jace.developers.alyssa.X99999.DG.DGVD;
import com.jace.developers.alyssa.X99999.DX.TR.TRLT;
import com.jace.developers.alyssa.X99999.GX.GXGD;
import com.jace.developers.alyssa.X99999.MX.MXSN;

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

public class XDUA extends AppCompatActivity implements
        DGSG.X336801720, DGVD.X311603390, DGVA.X311603391, DGMR.X113925000, DGCB.X113925001, DGCO.X113925002, DGTP.X113925003, DGMD.X113925004,
        DGUS.X113925005 {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    String XVBEHXCCR, XDAT, IXSN, NUPO, NUSN, CXFL, IXTR, TPRX, XYQMVAX9F, XVOIU8JJ5;

    private TextInputLayout LY_ASPO, LY_ASRP;
    private TextInputLayout LY_ASNO, LY_ASAP, LY_ASAM, LY_ASTL;
    private TextInputLayout LY_ASCL, LY_ASPL, LY_ASSR;
    private TextInputLayout LY_CDNO, LY_CDAP, LY_CDAM, LY_CDED, LY_CDDR, LY_CDTL, LY_CDEM, LY_CDTP;

    private Button ASSG;
    private Button ASVD;
    private Button ASVA;
    private Button ASCB;
    private Button ASCO;
    private Button ASMR;
    private Button ASTP;
    private Button ASMD;
    private Button ASUS;
    private Button CDVD;
    private Button CDVA;

    private EditText ASPO, ASRP;
    private EditText ASNO, ASAP, ASAM, ASTL;
    private EditText ASCL, ASPL, ASSR;
    private EditText CDNO, CDAP, CDAM, CDED, CDDR, CDTL, CDEM, CDTP;

    private TextView SGIX, COIX, CBIX, MRIX, TPIX, MDIX, USIX;

    String XCMC00, XCMC01, XCMC02, XCMC03, XCMC04, XCMC05, XCMC06, XCMC07, XCMC08, XCMC09, XCMC10;
    String XCMC11, XCMC12, XCMC13, XCMC14, XCMC15, XCMC16, XCMC17, XCMC18, XCMC19, XCMC20, XCMC21;
    String XCMC22, XCMC23, XCMC24, XCMC25, XCMC26, XCMC27;

    View XYJJRVR1X;
    View XYJJRVR2X;

    HttpURLConnection con;
    ProgressDialog pDialog;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dx_as_dua);

        XVBEHXCCR = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        NUPO = XCFG.GBF02();/** POLIZA  **/
        NUSN = XCFG.GBF01();/** SINIESTRO  **/

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CXFL = (String) extras.get("CXFL");
            if (CXFL != null) {
                switch (CXFL){
                    case "9333450231":
                        IXTR = (String) extras.get("IXTR");
                        break;
                    case "9333450232":
                        XVOIU8JJ5 = "9999999999";
                        XYQMVAX9F = "1189487001";
                        TPRX = (String) extras.get("TPIX");
                        IXTR = XJCX.xAKN("DKN");/** IX TERCERO **/
                        break;
                    default:
                        TPRX = "316263180778611";
                        IXTR = "999999999999999";
                        break;
                }
            }
        }

        // Toast.makeText(this, "FL "+CXFL, Toast.LENGTH_SHORT).show();

        // if (IXTR == null || IXTR.equals("")) { IXTR = "999999999999999"; }

        LY_ASPO = (TextInputLayout) findViewById(R.id.LY_ASPO);
        LY_ASRP = (TextInputLayout) findViewById(R.id.LY_ASRP);
        LY_ASNO = (TextInputLayout) findViewById(R.id.LY_ASNO);
        LY_ASAP = (TextInputLayout) findViewById(R.id.LY_ASAP);
        LY_ASAM = (TextInputLayout) findViewById(R.id.LY_ASAM);
        LY_ASTL = (TextInputLayout) findViewById(R.id.LY_ASTL);
        LY_ASCL = (TextInputLayout) findViewById(R.id.LY_ASCL);
        LY_ASPL = (TextInputLayout) findViewById(R.id.LY_ASPL);
        LY_ASSR = (TextInputLayout) findViewById(R.id.LY_ASSR);
        LY_CDNO = (TextInputLayout) findViewById(R.id.LY_CDNO);
        LY_CDAP = (TextInputLayout) findViewById(R.id.LY_CDAP);
        LY_CDAM = (TextInputLayout) findViewById(R.id.LY_CDAM);
        LY_CDED = (TextInputLayout) findViewById(R.id.LY_CDED);
        LY_CDDR = (TextInputLayout) findViewById(R.id.LY_CDDR);
        LY_CDTL = (TextInputLayout) findViewById(R.id.LY_CDTL);
        LY_CDEM = (TextInputLayout) findViewById(R.id.LY_CDEM);
        LY_CDTP = (TextInputLayout) findViewById(R.id.LY_CDTP);

        ASPO = (EditText) findViewById(R.id.ASPO);
        ASRP = (EditText) findViewById(R.id.ASRP);
        ASNO = (EditText) findViewById(R.id.ASNO);
        ASAP = (EditText) findViewById(R.id.ASAP);
        ASAM = (EditText) findViewById(R.id.ASAM);
        ASTL = (EditText) findViewById(R.id.ASTL);
        ASCL = (EditText) findViewById(R.id.ASCL);
        ASPL = (EditText) findViewById(R.id.ASPL);
        ASSR = (EditText) findViewById(R.id.ASSR);
        CDNO = (EditText) findViewById(R.id.CDNO);
        CDAP = (EditText) findViewById(R.id.CDAP);
        CDAM = (EditText) findViewById(R.id.CDAM);
        CDED = (EditText) findViewById(R.id.CDED);
        CDDR = (EditText) findViewById(R.id.CDDR);
        CDTL = (EditText) findViewById(R.id.CDTL);
        CDEM = (EditText) findViewById(R.id.CDEM);
        CDTP = (EditText) findViewById(R.id.CDTP);

        /** HIDDENS **/
        SGIX = (TextView) findViewById(R.id.SGIX);
        COIX = (TextView) findViewById(R.id.COIX);
        CBIX = (TextView) findViewById(R.id.CBIX);
        MRIX = (TextView) findViewById(R.id.MRIX);
        TPIX = (TextView) findViewById(R.id.TPIX);
        MDIX = (TextView) findViewById(R.id.MDIX);
        USIX = (TextView) findViewById(R.id.USIX);
        // LCIX = (TextView) findViewById(R.id.LCIX);

        /** BUTTONS **/
        ASSG = (Button) findViewById(R.id.ASSG);
        ASVD = (Button) findViewById(R.id.ASVD);
        ASVA = (Button) findViewById(R.id.ASVA);
        ASCB = (Button) findViewById(R.id.ASCB);
        ASCO = (Button) findViewById(R.id.ASCO);
        ASMR = (Button) findViewById(R.id.ASMR);
        ASTP = (Button) findViewById(R.id.ASTP);
        ASMD = (Button) findViewById(R.id.ASMD);
        ASUS = (Button) findViewById(R.id.ASUS);
        CDVD = (Button) findViewById(R.id.CDVD);
        CDVA = (Button) findViewById(R.id.CDVA);


        setTitle(null);
        Toolbar topToolBar = (Toolbar)findViewById(R.id.XJRQEFUFX);
        setSupportActionBar(topToolBar);
        topToolBar.setTitleTextColor(Color.WHITE);
        topToolBar.setNavigationIcon(R.drawable.back);

        if (!CXFL.equals("9333450231") && !CXFL.equals("9333450232")) {
            if (!NUPO.equals("")) { ASPO.setText(NUPO); } // NUMERO DE POLIZA
            if (!NUSN.equals("")) { ASRP.setText(NUSN); } // NUMERO DE SINIESTRO
        }

        /** ########################################################################## INI POPUP **/
        ASSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DGSG().show(getSupportFragmentManager(), "Aseguradora");
            }
        });

        ASVD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XYJJRVR1X = v;
                new DGVD().show(getSupportFragmentManager(), "Fecha");
            }
        });

        ASVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XYJJRVR2X = v;
                new DGVA().show(getSupportFragmentManager(), "Fecha");
            }
        });

        ASCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DGCB().show(getSupportFragmentManager(), "Cobertura");
            }
        });

        ASCO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DGCO().show(getSupportFragmentManager(), "Cobranza");
            }
        });

        ASMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DGMR().show(getSupportFragmentManager(), "Marcas");
            }
        });

        ASTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XCMC20 = MRIX.getText().toString();
                if (!XCMC20.equals("")) {
                    DGTP dialogFragment = DGTP.newInstance(XCMC20);
                    dialogFragment.show(getSupportFragmentManager(), "Tipo");
                    //new DGTP().show(getSupportFragmentManager(), "Tipo");
                } else {
                    XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR PRIMERO UNA MARCA -", false);
                }
            }
        });

        ASMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XCMC21 = TPIX.getText().toString();
                if (!XCMC21.equals("")) {
                    DGMD dialogFragment = DGMD.newInstance(XCMC21);
                    dialogFragment.show(getSupportFragmentManager(), "Modelos");
                    // new DGMD().show(getSupportFragmentManager(), "Modelo");
                } else {
                    XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR PRIMERO UN TIPO -", false);
                }
            }
        });

        ASUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DGUS().show(getSupportFragmentManager(), "Usos");
            }
        });

        CDVD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XYJJRVR1X = v;
                new DGVD().show(getSupportFragmentManager(), "Vigencia");
            }
        });

        CDVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XYJJRVR2X = v;
                new DGVA().show(getSupportFragmentManager(), "Vigencia");
            }
        });

        ASRP.addTextChangedListener(new MyTextWatcher(ASRP));
        ASPO.addTextChangedListener(new MyTextWatcher(ASPO));
        ASNO.addTextChangedListener(new MyTextWatcher(ASNO));
        ASAP.addTextChangedListener(new MyTextWatcher(ASAP));
        ASAM.addTextChangedListener(new MyTextWatcher(ASAM));
        ASTL.addTextChangedListener(new MyTextWatcher(ASTL));
        ASCL.addTextChangedListener(new MyTextWatcher(ASCL));
        ASPL.addTextChangedListener(new MyTextWatcher(ASPL));
        ASSR.addTextChangedListener(new MyTextWatcher(ASSR));
        CDNO.addTextChangedListener(new MyTextWatcher(CDNO));
        CDAP.addTextChangedListener(new MyTextWatcher(CDAP));
        CDAM.addTextChangedListener(new MyTextWatcher(CDAM));
        CDED.addTextChangedListener(new MyTextWatcher(CDED));
        CDDR.addTextChangedListener(new MyTextWatcher(CDDR));
        CDTL.addTextChangedListener(new MyTextWatcher(CDTL));
        CDEM.addTextChangedListener(new MyTextWatcher(CDEM));
        CDTP.addTextChangedListener(new MyTextWatcher(CDTP));

        if (!CXFL.equals("9333450232")){
            try {
                new X114045645().execute(new URL(XDAT));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        Button ASSV = (Button) findViewById(R.id.ASSV);
        ASSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        /** ########################################################################## FIN POPUP **/
    }

    @Override
    public void onSelectedAseguradora(String XG14ESSIX, String XG14ESSNO) {
        ASSG.setText(XG14ESSNO);
        SGIX.setText(XG14ESSIX);
    }

    @Override
    public void onSelectedDate(String XG14ESSFX) {
        if(XYJJRVR1X.getId()==R.id.ASVD){ //Si se ha pulsado btPrincipal
            ASVD.setText(XG14ESSFX);
        }else{
            CDVD.setText(XG14ESSFX);
        }
    }

    @Override
    public void onSelectedDateUntil(String XG14ESFXX) {
        if(XYJJRVR2X.getId()==R.id.ASVA){ //Si se ha pulsado btPrincipal
            ASVA.setText(XG14ESFXX);
        }else{
            CDVA.setText(XG14ESFXX);
        }
    }

    @Override
    public void onSelectedMarca(String XG14ESSIX, String XG14ESSNO) {
        MRIX.setText(XG14ESSIX);
        ASMR.setText(XG14ESSNO);
    }

    @Override
    public void onSelectedCobertura(String XG14ESSIX, String XG14ESSNO) {
        ASCB.setText(XG14ESSNO);
        CBIX.setText(XG14ESSIX);
    }

    @Override
    public void onSelectedCobranza(String XG14ESSIX, String XG14ESSNO) {
        ASCO.setText(XG14ESSNO);
        COIX.setText(XG14ESSIX);
    }

    @Override
    public void onSelectedTipo(String XG14ESSIX, String XG14ESSNO) {
        TPIX.setText(XG14ESSIX);
        ASTP.setText(XG14ESSNO);
    }

    @Override
    public void onSelectedModelo(String XG14ESSIX, String XG14ESSNO) {
        MDIX.setText(XG14ESSIX);
        ASMD.setText(XG14ESSNO);
    }

    @Override
    public void onSelectedUsos(String XG14ESSIX, String XG14ESSNO) {
        USIX.setText(XG14ESSIX);
        ASUS.setText(XG14ESSNO);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(XDUA.this, MXSN.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*********************************************************************** VALIDATING FORM INI **/
    private Boolean submitForm() {
        /** ASEGURADORA **/
        if (!X126731000()) { return false; } // ASEGURADORA
        if (!X126731001()) { return false; } // NUMERO DE POLIZA
        if (!X126731002()) { return false; } // NUMERO DE REPORTE
        if (!X126731003()) { return false; } // COBERTURA
        if (!X126731004()) { return false; } // COBRANZA

        /** ASEGURADO **/
        if (!X126731005()) { return false; } // NOMBRE
        if (!X126731006()) { return false; } // AP
        if (!X126731007()) { return false; } // AM
        if (!X126731008()) { return false; } // TELEFONO

        /** CONDUCTOR **/
        if (!X126731009()) { return false; } // NOMBRE
        if (!X126731010()) { return false; } // AP
        if (!X126731011()) { return false; } // AM
        if (!X126731012()) { return false; } // EDAD
        if (!X126731013()) { return false; } // DIRECCION
        if (!X126731014()) { return false; } // TELEFONO
        if (!X126731015()) { return false; } // EMAIL
        if (!X126731016()) { return false; } // TIPO LICENCIA

        /** VEHICULO **/
        if (!X126731017()) { return false; } // MARCA
        if (!X126731018()) { return false; } // TIPO
        if (!X126731019()) { return false; } // MODELO
        if (!X126731020()) { return false; } // USO
        if (!X126731021()) { return false; } // COLOR
        if (!X126731022()) { return false; } // PLACAS
        if (!X126731023()) { return false; } // SERIE VIN


        XCMC00 = SGIX.getText().toString(); // ASEGURADORA
        XCMC01 = ASPO.getText().toString(); // NUMERO DE POLIZA
        XCMC02 = ASRP.getText().toString(); // NUMERO DE REPORTE
        XCMC03 = ASVD.getText().toString(); // VIGENCIA DE
        XCMC04 = ASVA.getText().toString(); // VIGENCIA A
        XCMC05 = CBIX.getText().toString(); // COBERURA
        XCMC06 = COIX.getText().toString(); // COBRANZA

        XCMC07 = ASNO.getText().toString(); // NOMBRE
        XCMC08 = ASAP.getText().toString(); // AP
        XCMC09 = ASAM.getText().toString(); // AM
        XCMC10 = ASTL.getText().toString(); // TELEFONO

        XCMC11 = CDNO.getText().toString(); // NOMBRE
        XCMC12 = CDAP.getText().toString(); // AP
        XCMC13 = CDAM.getText().toString(); // AM
        XCMC14 = CDED.getText().toString(); // EDAD
        XCMC15 = CDDR.getText().toString(); // DIRECCION
        XCMC16 = CDTL.getText().toString(); // TELEFONO
        XCMC17 = CDEM.getText().toString(); // EMAIL
        XCMC18 = CDTP.getText().toString(); // TIPO LICENCIA
        XCMC19 = CDVD.getText().toString(); // VIGENCIA DE
        XCMC27 = CDVA.getText().toString(); // VIGENCIA A

        XCMC20 = MRIX.getText().toString(); // MARCA
        XCMC21 = TPIX.getText().toString(); // TIPO
        XCMC22 = MDIX.getText().toString(); // MODELO
        XCMC23 = USIX.getText().toString(); // USO
        XCMC24 = ASCL.getText().toString(); // COLOR
        XCMC25 = ASPL.getText().toString(); // PLACAS
        XCMC26 = ASSR.getText().toString(); // SERIE VIN

        try {
            new XDUA.X169184299().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        return true;
    }


    private boolean X126731000() {
        if (SGIX.getText().toString().trim().isEmpty()) {
            XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR UNA ASEGURADORA -", false);
            return false;
        }
        return true;
    }

    private boolean X126731001() {
        if (ASPO.getText().toString().trim().isEmpty()) {
            LY_ASPO.setErrorEnabled(true);
            LY_ASPO.setError(getString(R.string.dua_msg_err));
            requestFocus(ASPO);
            return false;
        } else {
            LY_ASPO.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731002() {
        if (ASRP.getText().toString().trim().isEmpty()) {
            LY_ASRP.setErrorEnabled(true);
            LY_ASRP.setError(getString(R.string.dua_msg_err));
            requestFocus(ASRP);
            return false;
        } else {
            LY_ASRP.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731003() {
        if (CBIX.getText().toString().trim().isEmpty()) {
            XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR UNA COBERTURA -", false);
            return false;
        }
        return true;
    }

    private boolean X126731004() {
        if (COIX.getText().toString().trim().isEmpty()) {
            XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR UNA OPCION PARA COBRANZA -", false);
            return false;
        }
        return true;
    }


    private boolean X126731005() {
        if (ASNO.getText().toString().trim().isEmpty()) {
            LY_ASNO.setErrorEnabled(true);
            LY_ASNO.setError(getString(R.string.dua_msg_err));
            requestFocus(ASNO);
            return false;
        } else {
            LY_ASNO.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731006() {
        if (ASAP.getText().toString().trim().isEmpty()) {
            LY_ASAP.setErrorEnabled(true);
            LY_ASAP.setError(getString(R.string.dua_msg_err));
            requestFocus(ASAP);
            return false;
        } else {
            LY_ASAP.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731007() {
        if (ASAM.getText().toString().trim().isEmpty()) {
            LY_ASAM.setErrorEnabled(true);
            LY_ASAM.setError(getString(R.string.dua_msg_err));
            requestFocus(ASAM);
            return false;
        } else {
            LY_ASAM.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731008() {
        if (ASTL.getText().toString().trim().isEmpty()) {
            LY_ASTL.setErrorEnabled(true);
            LY_ASTL.setError(getString(R.string.dua_msg_err));
            requestFocus(ASTL);
            return false;
        } else {
            LY_ASTL.setErrorEnabled(false);
        }
        return true;
    }


    private boolean X126731009() {
        if (CDNO.getText().toString().trim().isEmpty()) {
            LY_CDNO.setErrorEnabled(true);
            LY_CDNO.setError(getString(R.string.dua_msg_err));
            requestFocus(CDNO);
            return false;
        } else {
            LY_CDNO.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731010() {
        if (CDAP.getText().toString().trim().isEmpty()) {
            LY_CDAP.setErrorEnabled(true);
            LY_CDAP.setError(getString(R.string.dua_msg_err));
            requestFocus(CDAP);
            return false;
        } else {
            LY_CDAP.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731011() {
        if (CDAM.getText().toString().trim().isEmpty()) {
            LY_CDAM.setErrorEnabled(true);
            LY_CDAM.setError(getString(R.string.dua_msg_err));
            requestFocus(CDAM);
            return false;
        } else {
            LY_CDAM.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731012() {
        if (CDED.getText().toString().trim().isEmpty()) {
            LY_CDED.setErrorEnabled(true);
            LY_CDED.setError(getString(R.string.dua_msg_err));
            requestFocus(CDED);
            return false;
        } else {
            LY_CDED.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731013() {
        if (CDDR.getText().toString().trim().isEmpty()) {
            LY_CDDR.setErrorEnabled(true);
            LY_CDDR.setError(getString(R.string.dua_msg_err));
            requestFocus(CDDR);
            return false;
        } else {
            LY_CDDR.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731014() {
        if (CDTL.getText().toString().trim().isEmpty()) {
            LY_CDTL.setErrorEnabled(true);
            LY_CDTL.setError(getString(R.string.dua_msg_err));
            requestFocus(CDTL);
            return false;
        } else {
            LY_CDTL.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731015() {
        String email = CDEM.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
            LY_CDEM.setErrorEnabled(true);
            LY_CDEM.setError(getString(R.string.dua_msg_err));
            requestFocus(CDEM);
            return false;
        } else {
            LY_CDEM.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731016() {
        if (CDTP.getText().toString().trim().isEmpty()) {
            LY_CDTP.setErrorEnabled(true);
            LY_CDTP.setError(getString(R.string.dua_msg_err));
            requestFocus(CDTP);
            return false;
        } else {
            LY_CDTP.setErrorEnabled(false);
        }
        return true;
    }


    private boolean X126731017() {
        if (MRIX.getText().toString().trim().isEmpty()) {
            XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR UNA MARCA -", false);
            return false;
        }
        return true;
    }

    private boolean X126731018() {
        if (TPIX.getText().toString().trim().isEmpty()) {
            XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR UN TIPO -", false);
            return false;
        }
        return true;
    }

    private boolean X126731019() {
        if (MDIX.getText().toString().trim().isEmpty()) {
            XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR UN MODELO -", false);
            return false;
        }
        return true;
    }

    private boolean X126731020() {
        if (USIX.getText().toString().trim().isEmpty()) {
            XJCX.showAlertDialog(XDUA.this, "Alyssa", "- DEBES SELECCIONAR UN USO -", false);
            return false;
        }
        return true;
    }

    private boolean X126731021() {
        if (ASCL.getText().toString().trim().isEmpty()) {
            LY_ASCL.setErrorEnabled(true);
            LY_ASCL.setError(getString(R.string.dua_msg_err));
            requestFocus(ASCL);
            return false;
        } else {
            LY_ASCL.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731022() {
        if (ASPL.getText().toString().trim().isEmpty()) {
            LY_ASPL.setErrorEnabled(true);
            LY_ASPL.setError(getString(R.string.dua_msg_err));
            requestFocus(ASPL);
            return false;
        } else {
            LY_ASPL.setErrorEnabled(false);
        }
        return true;
    }

    private boolean X126731023() {
        if (ASSR.getText().toString().trim().isEmpty()) {
            LY_ASSR.setErrorEnabled(true);
            LY_ASSR.setError(getString(R.string.dua_msg_err));
            requestFocus(ASSR);
            return false;
        } else {
            LY_ASSR.setErrorEnabled(false);
        }
        return true;
    }


    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.LY_ASPO: X126731001(); break;
                case R.id.LY_ASRP: X126731002(); break;

                case R.id.LY_ASNO: X126731005(); break;
                case R.id.LY_ASAP: X126731006(); break;
                case R.id.LY_ASAM: X126731007(); break;
                case R.id.LY_ASTL: X126731008(); break;

                case R.id.LY_CDNO: X126731009(); break;
                case R.id.LY_CDAP: X126731010(); break;
                case R.id.LY_CDAM: X126731011(); break;
                case R.id.LY_CDED: X126731012(); break;
                case R.id.LY_CDDR: X126731013(); break;
                case R.id.LY_CDTL: X126731014(); break;
                case R.id.LY_CDEM: X126731015(); break;

                case R.id.LY_ASCL: X126731021(); break;
                case R.id.LY_ASPL: X126731022(); break;
                case R.id.LY_ASSR: X126731023(); break;
            }
        }
    }
    /*********************************************************************** VALIDATING FORM FIN **/

    /**************************************************************************** SELECT DUA INI **/
    public class X114045645 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("9736036001", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("FL", "UTF-8") + "=" + URLEncoder.encode(CXFL, "UTF-8");
                data += "&" + URLEncoder.encode("RG", "UTF-8") + "=" + URLEncoder.encode(IXTR, "UTF-8");

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
            pDialog = new ProgressDialog(XDUA.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                XYQMVAX9F = "1189487000";
                TPRX = "9999999999";
                XCFG.SBF03(IXTR);/** IX Tercero **/
                XVOIU8JJ5 = X11287.get(0).GXBDC36();
                SGIX.setText(X11287.get(0).GXBDC00()); // ASEGURADORA
                ASPO.setText(X11287.get(0).GXBDC01()); // NUMERO DE POLIZA
                ASRP.setText(X11287.get(0).GXBDC02()); // NUMERO DE REPORTE
                ASVD.setText(X11287.get(0).GXBDC03()); // VIGENCIA DE
                ASVA.setText(X11287.get(0).GXBDC04()); // VIGENCIA A
                CBIX.setText(X11287.get(0).GXBDC05()); // COBERURA
                COIX.setText(X11287.get(0).GXBDC06()); // COBRANZA

                ASNO.setText(X11287.get(0).GXBDC07()); // NOMBRE
                ASAP.setText(X11287.get(0).GXBDC08()); // AP
                ASAM.setText(X11287.get(0).GXBDC09()); // AM
                ASTL.setText(X11287.get(0).GXBDC10()); // TELEFONO

                CDNO.setText(X11287.get(0).GXBDC11()); // NOMBRE
                CDAP.setText(X11287.get(0).GXBDC12()); // AP
                CDAM.setText(X11287.get(0).GXBDC13()); // AM
                CDED.setText(X11287.get(0).GXBDC14()); // EDAD
                CDDR.setText(X11287.get(0).GXBDC15()); // DIRECCION
                CDTL.setText(X11287.get(0).GXBDC16()); // TELEFONO
                CDEM.setText(X11287.get(0).GXBDC17()); // EMAIL
                CDTP.setText(X11287.get(0).GXBDC18()); // TIPO LICENCIA
                CDVD.setText(X11287.get(0).GXBDC19()); // VIGENCIA DE
                CDVA.setText(X11287.get(0).GXBDC27()); // VIGENCIA A

                MRIX.setText(X11287.get(0).GXBDC20()); // MARCA
                TPIX.setText(X11287.get(0).GXBDC21()); // TIPO
                MDIX.setText(X11287.get(0).GXBDC22()); // MODELO
                USIX.setText(X11287.get(0).GXBDC23()); // USO
                ASCL.setText(X11287.get(0).GXBDC14()); // COLOR
                ASPL.setText(X11287.get(0).GXBDC25()); // PLACAS
                ASSR.setText(X11287.get(0).GXBDC26()); // SERIE VIN

                ASSG.setText(X11287.get(0).GXBDC28());
                ASCB.setText(X11287.get(0).GXBDC29());
                ASCO.setText(X11287.get(0).GXBDC30());
                ASMR.setText(X11287.get(0).GXBDC32());
                ASTP.setText(X11287.get(0).GXBDC33());
                ASMD.setText(X11287.get(0).GXBDC34());
                ASUS.setText(X11287.get(0).GXBDC35());
            }else{
                XYQMVAX9F = "1189487001";
                XVOIU8JJ5 = "9999999999";
                if (CXFL.equals("9333450231")){
                    IXTR = XJCX.xAKN("DKN");/** IX TERCERO **/
                }
            }
        }
    }
    /**************************************************************************** SELECT DUA FIN **/

    /**************************************************************************** INSERT DUA INI **/
    public class X169184299 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("9736036000", "UTF-8");
                data += "&" + URLEncoder.encode("MV", "UTF-8") + "=" + URLEncoder.encode(XVBEHXCCR, "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("FL", "UTF-8") + "=" + URLEncoder.encode(CXFL, "UTF-8");
                data += "&" + URLEncoder.encode("TR", "UTF-8") + "=" + URLEncoder.encode(IXTR, "UTF-8");
                data += "&" + URLEncoder.encode("TP", "UTF-8") + "=" + URLEncoder.encode(TPRX, "UTF-8");
                data += "&" + URLEncoder.encode("RG", "UTF-8") + "=" + URLEncoder.encode(XVOIU8JJ5, "UTF-8");
                data += "&" + URLEncoder.encode("AC", "UTF-8") + "=" + URLEncoder.encode(XYQMVAX9F, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC00", "UTF-8") + "=" + URLEncoder.encode(XCMC00, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC01", "UTF-8") + "=" + URLEncoder.encode(XCMC01, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC02", "UTF-8") + "=" + URLEncoder.encode(XCMC02, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC03", "UTF-8") + "=" + URLEncoder.encode(XCMC03, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC04", "UTF-8") + "=" + URLEncoder.encode(XCMC04, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC05", "UTF-8") + "=" + URLEncoder.encode(XCMC05, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC06", "UTF-8") + "=" + URLEncoder.encode(XCMC06, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC07", "UTF-8") + "=" + URLEncoder.encode(XCMC07, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC08", "UTF-8") + "=" + URLEncoder.encode(XCMC08, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC09", "UTF-8") + "=" + URLEncoder.encode(XCMC09, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC10", "UTF-8") + "=" + URLEncoder.encode(XCMC10, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC11", "UTF-8") + "=" + URLEncoder.encode(XCMC11, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC12", "UTF-8") + "=" + URLEncoder.encode(XCMC12, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC13", "UTF-8") + "=" + URLEncoder.encode(XCMC13, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC14", "UTF-8") + "=" + URLEncoder.encode(XCMC14, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC15", "UTF-8") + "=" + URLEncoder.encode(XCMC15, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC16", "UTF-8") + "=" + URLEncoder.encode(XCMC16, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC17", "UTF-8") + "=" + URLEncoder.encode(XCMC17, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC18", "UTF-8") + "=" + URLEncoder.encode(XCMC18, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC19", "UTF-8") + "=" + URLEncoder.encode(XCMC19, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC20", "UTF-8") + "=" + URLEncoder.encode(XCMC20, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC21", "UTF-8") + "=" + URLEncoder.encode(XCMC21, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC22", "UTF-8") + "=" + URLEncoder.encode(XCMC22, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC23", "UTF-8") + "=" + URLEncoder.encode(XCMC23, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC24", "UTF-8") + "=" + URLEncoder.encode(XCMC24, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC25", "UTF-8") + "=" + URLEncoder.encode(XCMC25, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC26", "UTF-8") + "=" + URLEncoder.encode(XCMC26, "UTF-8");
                data += "&" + URLEncoder.encode("XBDC27", "UTF-8") + "=" + URLEncoder.encode(XCMC27, "UTF-8");

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
            if (CXFL.equals("9333450232")){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(XDUA.this);
                builder1.setMessage("DESEAS AGREGAR OTRO TERCERO?");
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "SI",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Intent i = new Intent(XDUA.this, TRLT.class);
                                startActivity(i);
                            }
                        });

                builder1.setNegativeButton(
                        "NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                XCFG.SBF03(IXTR);/** IX Tercero **/
                                Intent i = new Intent(XDUA.this, GXGD.class);
                                startActivity(i);
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }else{
                Intent i = new Intent(XDUA.this, MXSN.class);
                startActivity(i);
            }
        }
    }
    /**************************************************************************** INSERT DUA FIN **/


}