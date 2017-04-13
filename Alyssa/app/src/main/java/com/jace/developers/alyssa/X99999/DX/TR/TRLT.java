package com.jace.developers.alyssa.X99999.DX.TR;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X87625.X77940;
import com.jace.developers.alyssa.X87625.X79141;
import com.jace.developers.alyssa.X99999.AX.AXTR;
import com.jace.developers.alyssa.X99999.DG.DGTT;
import com.jace.developers.alyssa.X99999.DX.AS.XDUA;
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

public class TRLT extends AppCompatActivity implements DGTT.X754277000 {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    MenuItem xitem;
    String XVBEHXCCR, XDAT, IXSN;
    TextView MSGX;

    HttpURLConnection con;
    ProgressDialog pDialog;
    private RecyclerView recycler;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tr_listadeterceros);

        XVBEHXCCR = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/

        setTitle(null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);

        MSGX = (TextView) findViewById(R.id.XFKN7IDKO);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.XCEIWSC3T);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getApplication());
        recycler.setLayoutManager(lManager);

        try {
            new X189193000().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tr_menu, menu);
        xitem = menu.findItem(R.id.action_add);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.action_add:
                new DGTT().show(getSupportFragmentManager(), "Involcrados");
                return true;
            case android.R.id.home:
                i = new Intent(TRLT.this, MXSN.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSelectedTipoTercero(String XG14ESSIX, String XG14ESSNO) {
        Intent i;
        switch (XG14ESSIX){
            case "716115445071471":
            case "216115451751049":
            case "316263585244737":
                i = new Intent(TRLT.this, XDUA.class);
                i.putExtra("TPNO",XG14ESSNO);
                i.putExtra("TPIX",XG14ESSIX);
                i.putExtra("CXFL","9333450232");
                startActivity(i);
                break;
            default:
                i = new Intent(TRLT.this, TRFR.class);
                i.putExtra("TPNO",XG14ESSNO);
                i.putExtra("TPIX",XG14ESSIX);
                i.putExtra("CXFL","9333450233");
                startActivity(i);
                break;
        }
    }


    public class X189193000 extends AsyncTask<URL, Integer, List<X77940>> {

        @Override
        protected List<X77940> doInBackground(URL... urls) {

            List<X77940> X73698 = null;

            try {
                String data = URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("3364932000", "UTF-8");
                data += "&" + URLEncoder.encode("SN", "UTF-8") + "=" + URLEncoder.encode(IXSN, "UTF-8");

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
            pDialog = new ProgressDialog(TRLT.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final List<X77940> X11287) {
            pDialog.dismiss();
            if(X11287!=null) {
                recycler.setVisibility(View.VISIBLE);
                final AXTR adaptador = new AXTR(X11287);
                adaptador.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XCFG.SBF03(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC00());/** IX Tercero **/
                        XCFG.SBF06(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC05());/** IX AA **/
                        XCFG.SBF07(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC06());/** IX BB **/
                        XCFG.SBF16(X11287.get(recycler.getChildAdapterPosition(view)).GXBDC07());/** IX Tipo Tercero **/

                        String XR91772X0 = X11287.get(recycler.getChildAdapterPosition(view)).GXBDC07();
                        String XBODYK0OA = X11287.get(recycler.getChildAdapterPosition(view)).GXBDC05();
                        String XBODYK0OB = X11287.get(recycler.getChildAdapterPosition(view)).GXBDC06();

                        switch (XR91772X0){
                            case "716115445071471":
                            case "216115451751049":
                            case "316263585244737":
                                if (XBODYK0OA.equals("0") && XBODYK0OB.equals("0")){
                                    Intent i = new Intent(TRLT.this, GXGD.class);
                                    startActivity(i);
                                }else{
                                    // Intent i = new Intent(TRLT.this, TRDT.class);
                                    Intent i = new Intent(TRLT.this, XDUA.class);
                                    i.putExtra("CXFL","9333450231");
                                    i.putExtra("IXTR",X11287.get(recycler.getChildAdapterPosition(view)).GXBDC00());
                                    startActivity(i);
                                }
                                break;
                            default:
                                XJCX.showAlertDialog(TRLT.this,"Alyssa", "ACCION NO DISPONIBLE", false);
                                break;
                        }
                    }
                });

                recycler.setAdapter(adaptador);
                recycler.setLayoutManager(new LinearLayoutManager(TRLT.this,LinearLayoutManager.VERTICAL,false));
            }else {
                // XJCX.showAlertDialog(TRLT.this,"Alyssa", "- NO SE ENCONTRARON REGISTROS -", false);
                MSGX.setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    public void onBackPressed() {  }
}
