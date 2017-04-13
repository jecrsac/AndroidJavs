package com.jace.developers.alyssa.X99999.DX.FT;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X51827;
import com.jace.developers.alyssa.X80784.X80644.X72086;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X99999.MX.MXSN;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FXCT extends AppCompatActivity {

    X72086 XCNX = new X72086();
    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    private static final int MY_WRITE_EXTERNAL_STORAGE = 0;
    private static int TAKE_PICTURE = 200;

    String XDAT, XBIN, IXSN, ROOT, THUM, NAME, XR4HN3I66, XHDZ4A59B, XT1CT43J5;

    ProgressDialog pDialog;
    File file;

    Vector<ImageView> mySDCardImages;
    TextView MSGX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dx_catalogofotos);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        XBIN = XCFG.GXBIN();/** URL BIN **/
        IXSN = XCFG.GBF00();/** IX  SIN **/
        XHDZ4A59B = "999999";

        /** PERMISSION **/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_WRITE_EXTERNAL_STORAGE);
                requestPermissions(new String[]{Manifest.permission.CAMERA}, TAKE_PICTURE);
            }
        }

        setTitle(null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);

        /** RUTAS **/
        XT1CT43J5 = IXSN;
        ROOT = XJCX.X165008671()+"/Alyssa/Fotos/"+XT1CT43J5+"/";
        THUM = XJCX.X165008671()+"/Alyssa/Fotos/"+XT1CT43J5+"/thumbnail/";

        /** NOMBRE IMG **/
        XR4HN3I66 = XJCX.xAKN("DKN")+".jpg";
        NAME = ROOT + XR4HN3I66;

        MSGX = (TextView) findViewById(R.id.XX4J5UEC9);

        List<FXIT> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(FXCT.this, 3);

        RecyclerView rView = (RecyclerView)findViewById(R.id.XSGVVS700);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        FXRV rcAdapter = new FXRV(FXCT.this, rowListItem);
        rView.setAdapter(rcAdapter);
        //rView.setAdapter(new X99010(getApplicationContext(), XP3243XJX));
        File sdDir = new File(THUM);
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
        inflater.inflate(R.menu.fotos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_fotos:

                XJCX.X165008670("/Alyssa/Fotos/"+XT1CT43J5+"/");
                XJCX.X165008670("/Alyssa/Fotos/"+XT1CT43J5+"/thumbnail/");
                String nomarchivo = ".Nomedia";
                File file = new File(THUM, nomarchivo);
                FileOutputStream out;
                try {
                    out = new FileOutputStream(file);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                int code = TAKE_PICTURE;
                Uri output = Uri.fromFile(new File(NAME));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
                startActivityForResult(intent, code);
                return true;
            case android.R.id.home:
                Intent i3 = new Intent(FXCT.this, MXSN.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private List<FXIT> getAllItemList(){

        mySDCardImages = new Vector<>();
        List<FXIT> allItems = new ArrayList<>();
        File sdDir = new File(THUM);
        File[] sdDirFiles = sdDir.listFiles();
        if (sdDirFiles != null) { int C = 1;
            for(File singleFile : sdDirFiles) {
                if (!singleFile.getName().equals(".Nomedia")){
                    ImageView myImageView = new ImageView(getBaseContext());
                    myImageView.setImageDrawable(Drawable.createFromPath(singleFile.getAbsolutePath()));
                    allItems.add(new FXIT("FOTO "+C, myImageView.getDrawable()));
                    C++;
                }
            }
        }
        return allItems;
    }


    /** # INI FUNCTIONS ######################################################################## **/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if (requestCode == TAKE_PICTURE) {
                if (data != null) {
                    if (data.hasExtra("data")) {
                        ImageView iv = (ImageView) findViewById(R.id.XB2C1EOFT);
                        if (iv != null) {
                            iv.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
                        }
                    }
                } else {
                    //ImageView iv = (ImageView)findViewById(R.id.XB2C1EOFT);
                    //iv.setImageBitmap(BitmapFactory.decodeFile(NAME));
                    new FXCT.CargaImagenes().execute(NAME);
                }
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle XTA2VPYUB) {
        super.onSaveInstanceState(XTA2VPYUB);
        //XT1CT43J5 = XCFG.GBF00();
        XTA2VPYUB.putString("SIN", XT1CT43J5);
    }

    @Override
    protected void onRestoreInstanceState(Bundle XEPU9XL2X) {
        super.onRestoreInstanceState(XEPU9XL2X);
        XT1CT43J5 = XEPU9XL2X.getString("SIN");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if ( pDialog!=null && pDialog.isShowing() ){
            pDialog.cancel();
        }
    }


    private class CargaImagenes extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pDialog = new ProgressDialog(FXCT.this);
            pDialog.setMessage("Cargando Imagen");
            pDialog.setCancelable(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // TODO Auto-generated method stub
            Log.i("doInBackground" , "Entra en doInBackground");
            String url = params[0];
            /*BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream is;
            try {
                is = getContentResolver().openInputStream(Uri.parse(url));
                BitmapFactory.decodeStream(is, null, options);
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            generalOptions = options;
            options.inJustDecodeBounds = false;
            return scaleImage(options, Uri.parse(url), 300);*/

            /*try {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(getContentResolver()
                        .openInputStream(Uri.parse(url)), null, options);
                options.inSampleSize = (int) Math.max(
                        Math.ceil(options.outWidth / 1024),
                        Math.ceil(options.outHeight / 1024));
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(url)), null, options);
            } catch (FileNotFoundException e) {
                //Toast.makeText(FXFT.this, "Fichero/recurso no encontrado", Toast.LENGTH_LONG).show();
                e.printStackTrace();
                return null;
            }*/

            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap thumbnail = BitmapFactory.decodeFile(url);
                int width = thumbnail != null ? thumbnail.getWidth() : 0;
                int height = thumbnail != null ? thumbnail.getHeight() : 0;
                int newWidth, newHeight;

                if (width>height){
                    newWidth = 533; newHeight = 300;
                }else{
                    newWidth = 300; newHeight = 533;
                }

                float scaleWidth = ((float) newWidth) / width;
                float scaleHeight = ((float) newHeight) / height;

                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);

                Bitmap resizedBitmap = Bitmap.createBitmap(thumbnail, 0, 0, thumbnail != null ? thumbnail.getWidth() : 0, thumbnail != null ? thumbnail.getHeight() : 0, matrix, true);
                file = new File (THUM, XR4HN3I66);


                try {
                    FileOutputStream out = new FileOutputStream(file);
                    resizedBitmap.compress(Bitmap.CompressFormat.JPEG  , 100, out);
                    out.flush();
                    out.close();
                    MediaScannerConnection.scanFile(FXCT.this, new String[]{file.getPath()}, new String[]{"image/jpeg"}, null);
                } catch (Exception e) {
                    Log.e("FALLO AL GUARDAR",e.getMessage()+"");
                }

                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(url)), null, options);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            pDialog.dismiss();
            // @SuppressLint("SimpleDateFormat") SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
            AlertDialog.Builder builder1 = new AlertDialog.Builder(FXCT.this);
            builder1.setMessage("ELIGE UNA ACCION A REALIZAR");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "SUBIR FOTO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            serverUpdate();
                        }
                    });

            builder1.setNegativeButton(
                    "TOMAR FOTO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent i = new Intent(FXCT.this, FXCT.class);
                            startActivity(i);
                        }
                    });

            builder1.setNeutralButton("SALIR",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    Intent i = new Intent(FXCT.this, MXSN.class);
                    startActivity(i);
                }
            });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

    }


    private void serverUpdate(){
        if (file.exists()){ new FXCT.ServerUpdate().execute(); }else{ Toast.makeText(FXCT.this, "ERROR "+file, Toast.LENGTH_LONG).show(); }
    }

    class ServerUpdate extends AsyncTask<String,String,String> {

        ProgressDialog pDialog;
        @Override
        protected String doInBackground(String... arg0) {
            String XCPS28MYC = XCNX.X718993000(FXCT.this);
            if(XCPS28MYC.equals("3718939417")){
                uploadFile(ROOT + XR4HN3I66);
            }else{
                uploadFile(THUM + XR4HN3I66);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(FXCT.this, "Exito al subir la imagen", Toast.LENGTH_LONG).show();
                    //finish();
                    Intent i = new Intent(FXCT.this, FXCT.class);
                    startActivity(i);
                }
            });

            return null;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(FXCT.this);
            pDialog.setMessage("Subiendo Imagen, espere..." );
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pDialog.dismiss();
        }
    }

    public void uploadFile(String filename){
        try {
            FileInputStream fis = new FileInputStream(filename);
            X51827 htfu = new X51827(XBIN+"?CR="+XT1CT43J5+"&TP=90891&DOC="+XHDZ4A59B,"noparamshere", filename);
            htfu.doStart(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /** # FIN FUNCTIONS ######################################################################## **/


    @Override
    public void onBackPressed() {  }
}
