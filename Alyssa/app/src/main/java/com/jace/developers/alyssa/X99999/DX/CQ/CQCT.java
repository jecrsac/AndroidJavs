package com.jace.developers.alyssa.X99999.DX.CQ;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X99999.MX.MXSN;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CQCT extends AppCompatActivity {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    Vector<ImageView> mySDCardImages;
    String XDAT, IXSN, XP3243XRT;
    TextView MSGX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dx_catalogocroquis);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        IXSN = XCFG.GBF00();/** IX  SIN **/

        setTitle(null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);

        XP3243XRT = XJCX.X165008671()+"/Alyssa/Croquis/"+IXSN+"/";

        MSGX = (TextView) findViewById(R.id.XX4J5UEC9);

        List<CQIT> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(CQCT.this, 3);

        RecyclerView rView = (RecyclerView)findViewById(R.id.XSJYMIVS3);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        CQRV rcAdapter = new CQRV(CQCT.this, rowListItem);
        rView.setAdapter(rcAdapter);
        //rView.setAdapter(new X99010(getApplicationContext(), XP3243XJX));
        File sdDir = new File(XP3243XRT);
        File[] sdDirFiles = sdDir.listFiles();
        if (sdDirFiles != null) {
            rView.setVisibility(View.VISIBLE);
        }else{
            MSGX.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.croquis, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_croquis:

                XJCX.X165008670("/Alyssa/Croquis/"+IXSN+"/");
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


                Intent i = new Intent (CQCT.this, CQNW.class);
                i.putExtra("DOC", "999999");
                startActivity(i);
                return true;
            case android.R.id.home:
                Intent i3 = new Intent(CQCT.this, MXSN.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private List<CQIT> getAllItemList(){

        mySDCardImages = new Vector<>();
        List<CQIT> allItems = new ArrayList<>();
        File sdDir = new File(XP3243XRT);
        File[] sdDirFiles = sdDir.listFiles();
        if (sdDirFiles != null) { int C = 1;
            for(File singleFile : sdDirFiles) {
                if(!singleFile.getName().equals(".Nomedia")){
                    ImageView myImageView = new ImageView(getBaseContext());
                    myImageView.setImageDrawable(Drawable.createFromPath(singleFile.getAbsolutePath()));
                    allItems.add(new CQIT("IMAGEN "+C, myImageView.getDrawable()));
                    C++;
                }
            }
        }
        return allItems;
    }

    @Override
    public void onBackPressed() {  }
}
