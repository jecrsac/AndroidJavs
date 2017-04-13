package com.jace.developers.alyssa.X99999.UX;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X86870.X18800;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UXST extends Fragment {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(getActivity());
    X18800 XDBX;

    String XDAT, XFQIJLRNO, XFQIJLREM, XFQIJLRTL, XVBEHXCCR, XVR593Z93, XP3243XJX;
    Button XND2FJ2JD;
    TextView XI5IQTFXK, XBIE926NO, XBIE926EM, XBIE926TL;
    HttpURLConnection con = null;
    ProgressDialog pDialog;


    public UXST() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        XCFG = (X86082) getContext().getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/

        XDBX = new X18800(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.us_status, container, false);

        XND2FJ2JD = (Button) rootView.findViewById(R.id.status);
        XI5IQTFXK = (TextView) rootView.findViewById(R.id.XSSJVNFCN);
        XBIE926NO = (TextView) rootView.findViewById(R.id.NAME);
        XBIE926EM = (TextView) rootView.findViewById(R.id.EMAIL);
        XBIE926TL = (TextView) rootView.findViewById(R.id.TEL);

        XP3243XJX = XJCX.X165008671()+"/Alyssa/Perfil/";
        File imgFile = new  File(XP3243XJX+"F50012.jpg");

        CircleImageView imageView = (CircleImageView) rootView.findViewById(R.id.fotoPerfil);
        if(imgFile.exists()){
            Bitmap icon = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(icon);
        }else {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.icon,null));
        }

        try {
            X833634912();
            XBIE926NO.setText(XFQIJLRNO);
            XBIE926EM.setText(XFQIJLREM);
            XBIE926TL.setText(XFQIJLRTL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            new X120473131().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (XND2FJ2JD != null) {
            XND2FJ2JD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        new X120473130().execute(new URL(XDAT));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        return rootView;

    }

    public void X833634912() throws SQLException {
        XDBX.open();
        Cursor c = XDBX.X810634302();
        if (c.moveToFirst()) {
            do { X833634913(c); } while (c.moveToNext());
        }
        XDBX.close();
    }

    public void X833634913(Cursor c) {
        XFQIJLRNO = c.getString(2)+" "+c.getString(3);
        XFQIJLREM = c.getString(5);
        XFQIJLRTL = c.getString(4);
    }




    public class X120473131 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;
            XVBEHXCCR  = Settings.Secure.getString(getActivity().getApplication().getContentResolver(), Settings.Secure.ANDROID_ID);

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("4250355000", "UTF-8");
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

                //con = (HttpURLConnection)urls[0].openConnection();
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
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                final String[] TPIX = new String[X11287.size()];
                TPIX[0] = X11287.get(0).GXBDC01();

                switch (TPIX[0]){
                    case "516200361627164"://Comiendo
                        XND2FJ2JD.setBackgroundColor(0xfff3f315);
                        XND2FJ2JD.setText(X11287.get(0).GXBDC02());
                        break;
                    case "116200332421916"://Ocupado
                        XND2FJ2JD.setBackgroundColor(0xff930c09);
                        XND2FJ2JD.setText(X11287.get(0).GXBDC02());
                        break;
                    case "116200331815436"://Disponible
                        XND2FJ2JD.setBackgroundColor(0xff2db11d);
                        XND2FJ2JD.setText(X11287.get(0).GXBDC02());
                        break;
                    case "116200472521168"://En Siniestro
                        XND2FJ2JD.setBackgroundColor(0xfffc7205);
                        XND2FJ2JD.setText(X11287.get(0).GXBDC02());
                        break;
                    default:
                        XND2FJ2JD.setBackgroundColor(0xffa9a9a9);
                        XND2FJ2JD.setText(X11287.get(0).GXBDC02());
                        break;
                }
            }
        }
    }

    public class X120473130 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("4250355001", "UTF-8");

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

                //con = (HttpURLConnection)urls[0].openConnection();
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
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {

            if(X11287!=null) {

                final String[] TPNO = new String[X11287.size()];
                final String[] TPIX = new String[X11287.size()];

                for (int c=0; c<TPNO.length; c++ ) {
                    TPNO[c] = X11287.get(c).GXBDC02();
                    TPIX[c] = X11287.get(c).GXBDC00();
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(getActivity());

                dialogo.setTitle("SELECCIONA UNA OPCION");
                dialogo.setItems(TPNO, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        pDialog.dismiss();
                        switch (TPIX[item]){
                            case "516200361627164"://Comiendo
                                XND2FJ2JD.setBackgroundColor(0xfff3f315);
                                XND2FJ2JD.setText(X11287.get(item).GXBDC02());
                                break;
                            case "116200332421916"://Ocupado
                                XND2FJ2JD.setBackgroundColor(0xff930c09);
                                XND2FJ2JD.setText(X11287.get(item).GXBDC02());
                                break;
                            case "116200331815436"://Disponible
                                XND2FJ2JD.setBackgroundColor(0xff2db11d);
                                XND2FJ2JD.setText(X11287.get(item).GXBDC02());
                                break;
                            case "116200472521168"://En Siniestro
                                XND2FJ2JD.setBackgroundColor(0xfffc7205);
                                XND2FJ2JD.setText(X11287.get(item).GXBDC02());
                                break;
                            default:
                                XND2FJ2JD.setBackgroundColor(0xffa9a9a9);
                                XND2FJ2JD.setText(X11287.get(item).GXBDC02());
                                break;
                        }

                        XVR593Z93 = TPIX[item];

                        try {
                            new X169184299().execute(new URL(XDAT));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                });

                dialogo.create();
                dialogo.show();

            }
        }
    }

    public class X169184299 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            XVBEHXCCR  = Settings.Secure.getString(getActivity().getApplication().getContentResolver(), Settings.Secure.ANDROID_ID);

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("4250355002", "UTF-8");
                data += "&" + URLEncoder.encode("ST", "UTF-8") + "=" + URLEncoder.encode(XVR593Z93, "UTF-8");
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
            Toast.makeText(getActivity(), "Estatus Actualizado", Toast.LENGTH_LONG).show();
        }
    }



}
