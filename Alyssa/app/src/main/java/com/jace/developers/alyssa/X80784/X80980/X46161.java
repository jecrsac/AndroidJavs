package com.jace.developers.alyssa.X80784.X80980;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

public class X46161 extends BroadcastReceiver {

    Context c;
    X99099 XWUKQ81JC = new X99099(c);
    X86082 XCFG = new X86082();
    HttpURLConnection con;
    String XVBEHXCCR, XDAT;
    double LAT = 0;
    double LON = 0;
    String DIR = "Not Found";

    @SuppressLint("HardwareIds")
    @Override
    public void onReceive(Context context, Intent intent) {
        String locationKey = LocationManager.KEY_LOCATION_CHANGED;
        String providerEnabledKey = LocationManager.KEY_PROVIDER_ENABLED;
        c=context;
        XVBEHXCCR  = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        XCFG = (X86082) c.getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/

        // Toast.makeText(context, "CBX - Actualiza Ubicacion", Toast.LENGTH_SHORT).show();

        if (intent.hasExtra(providerEnabledKey)) {
            if (!intent.getBooleanExtra(providerEnabledKey, true)) {
                Toast.makeText(context,
                        "Provider disabled",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        "Provider enabled",
                        Toast.LENGTH_SHORT).show();
            }
        }

        if (intent.hasExtra(locationKey)) {
            Location loc = (Location)intent.getExtras().get(locationKey);
            /*Toast.makeText(context,
                    "Location changed : Lat: " + (loc != null ? loc.getLatitude() : 0) +
                            " Lng: " + (loc != null ? loc.getLongitude() : 0),
                    Toast.LENGTH_SHORT).show();*/

            LAT = loc != null ? loc.getLatitude() : 0;
            LON = loc != null ? loc.getLongitude() : 0;

            this.setLocation(loc);

            try {
                new X358786300().execute(new URL(XDAT));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLocation(Location loc) {
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(c, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address address = list.get(0);
                    //Toast.makeText(c, "Mi direccion es: \n" + address.getAddressLine(0), Toast.LENGTH_SHORT).show();
                    if (address.getAddressLine(0) != null){
                        DIR = address.getAddressLine(0);
                    }else{
                        DIR = "Not found";
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class X358786300 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("1873903719", "UTF-8");
                data += "&" + URLEncoder.encode("LT", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(LAT), "UTF-8");
                data += "&" + URLEncoder.encode("LG", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(LON), "UTF-8");
                data += "&" + URLEncoder.encode("DR", "UTF-8") + "=" + URLEncoder.encode(DIR, "UTF-8");
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
            Log.d("CBX","Ubicacion Actualizada");
        }
    }


}
