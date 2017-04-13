package com.jace.developers.alyssa.X99999.SX;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class SXAC extends AppCompatActivity {

    X99099 XJCX = new X99099(this);
    X86082 XCFG = new X86082();

    String XVBEHXCCR, XDAT;
    String NOSN, IXSN, XP3243XRT;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_acciones);

        XVBEHXCCR  = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/

        NOSN  = XCFG.GBF01();
        IXSN  = XCFG.GBF00();

        XVBEHXCCR  = Settings.Secure.getString(getApplication().getContentResolver(), Settings.Secure.ANDROID_ID);

        XP3243XRT = XJCX.X165008671()+"/Alyssa/Fotos/"+IXSN+"/";

        TextView X68999 = (TextView) findViewById(R.id.XI7MD9KGX);
        if (X68999 != null) {
            X68999.setText(NOSN);
        }

    }

    public void onClickINI (View v) throws MalformedURLException {
        XJCX.X165008670("/Alyssa/Fotos/"+IXSN+"/");
        XJCX.X165008670("/Alyssa/Fotos/"+IXSN+"/thumbnail/");
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
        Intent i = new Intent (SXAC.this, SXPL.class);
        startActivity(i);
    }

    public void onClickCAN (View v) throws MalformedURLException {
        Intent i = new Intent (SXAC.this, SXCL.class);
        i.putExtra("IXSN", IXSN);
        i.putExtra("ACT", "9159353002");
        startActivity(i);
    }

    public void onClickLOC (View v) throws MalformedURLException {
        Intent i = new Intent (SXAC.this, SXCL.class);
        i.putExtra("IXSN", IXSN);
        i.putExtra("ACT", "9159353003");
        startActivity(i);
    }

    public void onClickARR (View v) throws MalformedURLException {
        Intent i = new Intent (SXAC.this, SXCL.class);
        i.putExtra("IXSN", IXSN);
        i.putExtra("ACT", "9159353004");
        startActivity(i);
    }


    @Override
    public void onBackPressed() {  }
}
