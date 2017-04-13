package com.jace.developers.alyssa.X80784.X80644;

import android.content.Context;
import android.os.AsyncTask;

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


public class X80792 extends AsyncTask<URL, Void, List<X77940>> {

    Context c;
    public X80792(Context context) { c = context; }

    X86082 XCFG = new X86082();
    String XURL, XTKJ;
    URL XR6CAFJ5T = null;
    HttpURLConnection XK0E3FX2C;
    public X99099.AsyncResponse XZJI9G307 = null;

    @Override
    protected List<X77940> doInBackground(URL... urls) {

        List<X77940> X73698 = null;

        XCFG = (X86082) c.getApplicationContext();
        XURL = XCFG.GXJSN();
        XTKJ = XCFG.GXTKJ();

        try { XR6CAFJ5T = new URL(XURL); } catch (MalformedURLException e) { e.printStackTrace(); }

        try {
            String data = URLEncoder.encode("APPI", "UTF-8") + "=" + URLEncoder.encode(XTKJ, "UTF-8");

            XK0E3FX2C = (HttpURLConnection) (XR6CAFJ5T != null ? XR6CAFJ5T.openConnection() : null);
            if (XK0E3FX2C != null) {
                XK0E3FX2C.setRequestMethod("POST");
                XK0E3FX2C.setDoInput(true);
                XK0E3FX2C.setDoOutput(true);
                XK0E3FX2C.setFixedLengthStreamingMode(data.getBytes().length);
                XK0E3FX2C.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                OutputStream out = new BufferedOutputStream(XK0E3FX2C.getOutputStream());

                out.write(data.getBytes());
                out.flush();
                out.close();

                int statusCode = XK0E3FX2C.getResponseCode();

                if(statusCode!=200) {
                    X73698 = new ArrayList<>();
                    X73698.add(new X77940());
                }else{
                    InputStream in = new BufferedInputStream(XK0E3FX2C.getInputStream());
                    X79141 parser = new X79141();
                    X73698 = parser.X335987082(in);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(XK0E3FX2C!=null){ XK0E3FX2C.disconnect(); }
        }

        return X73698;
    }

    @Override
    protected void onPostExecute(List<X77940> X73698) {
        if(X73698!=null) {
            XZJI9G307.processFinish(X73698);
        }
    }
}
