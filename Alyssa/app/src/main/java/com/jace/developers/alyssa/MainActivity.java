package com.jace.developers.alyssa;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.jace.developers.alyssa.X80784.X80644.X72086;
import com.jace.developers.alyssa.X80784.X80644.X80792;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X80980.X46160;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X86870.X18800;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X99999.CX.CXMN;
import com.jace.developers.alyssa.X99999.UX.UXRG;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements X99099.AsyncResponse{

    X72086 XCNX = new X72086();
    X86082 XCFG = new X86082();
    X80792 XJSN = new X80792(this);
    X18800 XDBX = new X18800(this);

    String XSKN, XIMG;
    int X18192;
    ProgressBar XJDUD9ZPB;
    PendingIntent pendingSiniestro;


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    /** Called when the activity is first created. */
    Thread splashTread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XCFG = (X86082) getApplicationContext();
        XSKN = XCFG.GXSKN();

        FrameLayout XKX7PE0JC = (FrameLayout) findViewById(R.id.XXN9PJP64);
        FrameLayout XKX7PE0JR = (FrameLayout) findViewById(R.id.XXN9PJP65);
        FrameLayout XTT1ZFOPR = (FrameLayout) findViewById(R.id.XPZ6TUO1X);

        X981330100 XX4VDSK3S = new X981330100(this);

        switch (XSKN){
            case "7157383317":
                XKX7PE0JC.setVisibility(View.VISIBLE);
                ImageView XFNQGV04S = (ImageView) findViewById(R.id.XJZXTYPGW);
                XJDUD9ZPB = (ProgressBar)findViewById(R.id.XG9M7ETSR);
                XIMG = "splash";
                X18192 = getResources().getIdentifier(XIMG, "drawable", getPackageName());
                if (XFNQGV04S != null) { XFNQGV04S.setImageResource(X18192); }
                XX4VDSK3S.execute();
                break;
            case "7212016330":
                XTT1ZFOPR.setVisibility(View.VISIBLE);
                ImageView XYPJM4IXA = (ImageView) findViewById(R.id.XXRAFPA3X);
                XIMG = "logo";
                X18192 = getResources().getIdentifier(XIMG, "drawable", getPackageName());
                if (XYPJM4IXA != null) { XYPJM4IXA.setImageResource(X18192); }
                break;
            default:
                XKX7PE0JR.setVisibility(View.VISIBLE);
                ImageView XZSJH1F5R = (ImageView) findViewById(R.id.XJ1LM7KVW);
                XJDUD9ZPB = (ProgressBar) findViewById(R.id.XECUO7TJJ);

                String IMG = "logo";
                X18192 = getResources().getIdentifier(IMG, "drawable", getPackageName());
                if (XZSJH1F5R != null) { XZSJH1F5R.setImageResource(X18192); }

                if (XJDUD9ZPB != null) {
                    XJDUD9ZPB.setMax(100);
                    XJDUD9ZPB.setBackgroundColor(Color.TRANSPARENT);
                    XJDUD9ZPB.setProgress(0);
                }

                XX4VDSK3S.execute();
                break;
        }


        if(XCNX.X979095000(this)){ XJSN.XZJI9G307 = this; XJSN.execute(); }

        Intent alarmIntent = new Intent(getApplicationContext(), X46160.class);
        pendingSiniestro = PendingIntent.getBroadcast(
                getApplicationContext(), 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis(), 60000, pendingSiniestro);

        StartAnimations();

    }

    @Override
    public void processFinish(List<X77940> X88000) {
        XCFG.SXDAT(X88000.get(0).GXBDC00());
        XCFG.SXBIN(X88000.get(0).GXBDC01());
    }

    public class X981330100 extends AsyncTask<Void, Integer, Void> {

        Context XKSQ9Q28I;
        X981330100(Context context){ XKSQ9Q28I = context; }

        @Override
        protected Void doInBackground(Void... params) {
            publishProgress(0);
            for (int C = 0; C < 100; C++){
                try {
                    Thread.sleep(25);
                    publishProgress(C + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... value){
            XJDUD9ZPB.setProgress(value[0]);
        }

        @Override
        protected void onPostExecute(Void result) {
            try { XDBX.open(); } catch (SQLException e) { e.printStackTrace(); }
            Cursor r = XDBX.X810634302();

            if (r.moveToFirst()) {
                /* Existen Registros CREDENCIAL */
                XKSQ9Q28I.startActivity(new Intent(XKSQ9Q28I, CXMN.class));
                finish();
            }else{
                /* NO Existen Registros CREDENCIAL */
                XKSQ9Q28I.startActivity(new Intent(XKSQ9Q28I, UXRG.class));
                finish();
            }

            XDBX.close();
            r.close();
            finish();
        }
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.XRY5N75RW);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.XXRAFPA3X);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }

                    try { XDBX.open(); } catch (SQLException e) { e.printStackTrace(); }
                    Cursor r = XDBX.X810634302();

                    if (r.moveToFirst()) {
                        /* Existen Registros CREDENCIAL */
                        Intent intent = new Intent(MainActivity.this, CXMN.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        MainActivity.this.finish();
                    }else{
                        /* NO Existen Registros CREDENCIAL */
                        Intent intent = new Intent(MainActivity.this, UXRG.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        MainActivity.this.finish();
                    }

                    XDBX.close();
                    r.close();

                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    MainActivity.this.finish();
                }

            }
        };
        splashTread.start();

    }
}
