package com.jace.developers.alyssa.X99999.MX;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X99999.CX.CXMN;

import java.util.ArrayList;
import java.util.List;


public class MXSN extends AppCompatActivity {

    X86082 XCFG = new X86082();
    String SXNO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mn_siniestrodetalle);

        XCFG = (X86082) getApplicationContext();
        SXNO = XCFG.GBF01();/** URL DAT **/

        setTitle("Siniestro - "+SXNO);
        Toolbar topToolBar = (Toolbar)findViewById(R.id.XZKX2I4CJ);
        setSupportActionBar(topToolBar);
        topToolBar.setTitleTextColor(Color.WHITE);
        topToolBar.setNavigationIcon(R.drawable.back);
        // topToolBar.setLogo(R.drawable.logo);
        // topToolBar.setLogoDescription(getResources().getString(R.string.app_legales));

        List<MXIT> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(MXSN.this, 3);

        RecyclerView rView = (RecyclerView)findViewById(R.id.XOMJNNJS5);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        MXRV rcAdapter = new MXRV(MXSN.this, rowListItem);
        rView.setAdapter(rcAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Log.i("ActionBar", "Atrás!");
                Intent i3 = new Intent(MXSN.this, CXMN.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private List<MXIT> getAllItemList(){

        List<MXIT> allItems = new ArrayList<>();
        allItems.add(new MXIT("FOTOS", R.drawable.m_camara));
        allItems.add(new MXIT("CROQUIS", R.drawable.m_croquis));
        allItems.add(new MXIT("NOTAS", R.drawable.m_audio));
        allItems.add(new MXIT("ASEGURADO", R.drawable.m_user));
        allItems.add(new MXIT("TERCERO", R.drawable.m_tercero));
        allItems.add(new MXIT("INFORME", R.drawable.m_reporte));

        return allItems;
    }

    @Override
    public void onBackPressed() {  }

}
