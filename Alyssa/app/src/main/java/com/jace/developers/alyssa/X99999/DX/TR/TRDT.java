package com.jace.developers.alyssa.X99999.DX.TR;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.AX.AXRD;
import com.jace.developers.alyssa.X99999.GX.GXRS;
import com.jace.developers.alyssa.X99999.GX.GXTS;

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

public class TRDT extends AppCompatActivity {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    MenuItem xitem;
    String XDAT, IXSN, IXTR;

    HttpURLConnection con;
    ProgressDialog pDialog;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tr_detalle);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        IXTR = XCFG.GBF03();/** IX  TER **/

        setTitle(null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.XQK7GPD2H);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getApplication());
        recycler.setLayoutManager(lManager);

        try {
            new X712440028().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tr_detalle, menu);
        xitem = menu.findItem(R.id.action_add);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.action_add:
                i = new Intent(TRDT.this, GXRS.class);
                startActivity(i);
                return true;
            case R.id.action_inf:
                Toast.makeText(TRDT.this, "INFO", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                i = new Intent(TRDT.this, TRLT.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class X712440028 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932009", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");
                data += "&" + URLEncoder.encode("IV", "UTF-8") + "=" + URLEncoder.encode(IXTR, "UTF-8");

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
            pDialog = new ProgressDialog(TRDT.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                final AXRD adaptador = new AXRD(getApplicationContext(),X11287);
                adaptador.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XCFG.SBF13(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC00());/** Instancia **/
                        XCFG.SBF09(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC03());/** Resultado **/
                        XCFG.SBF10(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC04());/** Formulario **/
                        Intent i = new Intent(TRDT.this, GXTS.class);
                        i.putExtra("ACT", "14912");
                        startActivity(i);
                    }
                });

                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(TRDT.this,LinearLayoutManager.VERTICAL,false));
            }else {
                XJCX.showAlertDialog(TRDT.this,"Alyssa", "- NO SE ENCONTRARON REGISTROS -", false);
            }
        }
    }


    @Override
    public void onBackPressed() {  }

}
