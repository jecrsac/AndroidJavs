package com.jace.developers.alyssa.X99999.UX;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X86870.X18800;
import com.jace.developers.alyssa.X99999.CX.CXMN;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;

public class UXRG extends AppCompatActivity {

    //X72086 XCNX = new X72086();
    X86082 XCFG = new X86082();
    //X80792 XJSN = new X80792(this);
    X99099 XJCX = new X99099(this);
    X18800 XDBX = new X18800(this);

    String XDAT, XBIN;

    private EditText no;
    private EditText ap;
    private EditText ce;
    private EditText tl;
    private EditText im;

    ImageView XCSWO47OP;
    HttpURLConnection con;

    private TextInputLayout input_layout_no, input_layout_ap, input_layout_tl, input_layout_ce;
    private String XVBEHXCCR;

    private static final int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private static final int MY_WRITE_EXTERNAL_STORAGE = 0;
    private static final int CAMERA_REQUEST = 1;
    private static final int FINE_LOCATION = 3;

    String XP3243XJX, D12800, D12801, D12802, D12803, D12804,S99100;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ux_registro);

        XP3243XJX = XJCX.X165008671()+"/Alyssa/Perfil/";
        XVBEHXCCR  = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        XBIN = XCFG.GXBIN();/** URL BIN **/

        S99100 = XJCX.xAKN("DKN");
        XP3243XJX = XJCX.X165008671()+"/Alyssa/Perfil/";

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, COARSE_LOCATION_REQUEST);
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION);
            }
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_WRITE_EXTERNAL_STORAGE);
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
            }
        }

        input_layout_no = (TextInputLayout) findViewById(R.id.input_layout_no);
        input_layout_ap = (TextInputLayout) findViewById(R.id.input_layout_ap);
        input_layout_tl = (TextInputLayout) findViewById(R.id.input_layout_tl);
        input_layout_ce = (TextInputLayout) findViewById(R.id.input_layout_ce);

        no = (EditText) findViewById(R.id.X33100);
        ap = (EditText) findViewById(R.id.X33101);
        tl = (EditText) findViewById(R.id.X33102);
        ce = (EditText) findViewById(R.id.X33103);
        im = (EditText) findViewById(R.id.X33104);

        Button b77000 = (Button) findViewById(R.id.B77000);

        no.addTextChangedListener(new MyTextWatcher(no));
        ap.addTextChangedListener(new MyTextWatcher(ap));
        tl.addTextChangedListener(new MyTextWatcher(tl));
        ce.addTextChangedListener(new MyTextWatcher(ce));

        XCSWO47OP = (ImageView) findViewById(R.id.ftPERFIL);
        XCSWO47OP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                X984527727();
            }
        });

        b77000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

    }



    /** VALIDATING FORM INI ***********************************************************************/
    private Boolean submitForm() {
        if (!validateName()) {
            return false;
        }

        if (!validateLastName()) {
            return false;
        }

        if (!validatePhone()) {
            return false;
        }

        if (!validateEmail()) {
            return false;
        }

        D12800 = no.getText().toString();
        D12801 = ap.getText().toString();
        D12802 = tl.getText().toString();
        D12803 = ce.getText().toString();
        D12804 = im.getText().toString();

        try { X833634911(); } catch (SQLException e) { e.printStackTrace(); }
        try {
            new X169184299().execute(new URL(XDAT));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean validateName() {
        if (no.getText().toString().trim().isEmpty()) {
            input_layout_no.setErrorEnabled(true);
            input_layout_no.setError(getString(R.string.err_msg_no));
            //requestFocus(no);
            return false;
        } else {
            input_layout_no.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateLastName() {
        if (ap.getText().toString().trim().isEmpty()) {
            input_layout_ap.setError(getString(R.string.err_msg_ap));
            requestFocus(ap);
            return false;
        } else {
            input_layout_ap.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = ce.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            input_layout_ce.setError(getString(R.string.err_msg_ce));
            requestFocus(ce);
            return false;
        } else {
            input_layout_ce.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhone() {
        if (tl.getText().toString().trim().isEmpty()) {
            input_layout_tl.setError(getString(R.string.err_msg_tl));
            requestFocus(tl);
            return false;
        } else {
            input_layout_tl.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_layout_no:
                    validateName();
                    break;
                case R.id.input_layout_ap:
                    validateLastName();
                    break;
                case R.id.input_layout_tl:
                    validatePhone();
                    break;
                case R.id.input_layout_ce:
                    validateEmail();
                    break;
            }
        }
    }
    /** VALIDATING FORM FIN ***********************************************************************/



    /** INSERT DATA INI ***************************************************************************/
    public class X169184299 extends AsyncTask<URL, Void, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            try {
                String data = URLEncoder.encode("IX", "UTF-8") + "=" + URLEncoder.encode(S99100, "UTF-8");
                data += "&" + URLEncoder.encode("NO", "UTF-8") + "=" + URLEncoder.encode(D12800, "UTF-8");
                data += "&" + URLEncoder.encode("AP", "UTF-8") + "=" + URLEncoder.encode(D12801, "UTF-8");
                data += "&" + URLEncoder.encode("TL", "UTF-8") + "=" + URLEncoder.encode(D12802, "UTF-8");
                data += "&" + URLEncoder.encode("CE", "UTF-8") + "=" + URLEncoder.encode(D12803, "UTF-8");
                data += "&" + URLEncoder.encode("MV", "UTF-8") + "=" + URLEncoder.encode(XVBEHXCCR, "UTF-8");
                data += "&" + URLEncoder.encode("TK", "UTF-8") + "=" + URLEncoder.encode("9115968159", "UTF-8");

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
            Toast.makeText(getBaseContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
            startActivity(new Intent(UXRG.this, CXMN.class));
        }
    }

    public void X833634911() throws SQLException {
        XDBX.open();
        XDBX.X126132701(S99100, D12800, D12801, D12802, D12803, XVBEHXCCR);
        XDBX.close();
    }
    /** INSERT DATA FIN ***************************************************************************/


    /** UPLOAD IMAGE INI **************************************************************************/
    private void X984527727() {
        XJCX.X165008670("/Alyssa/Perfil/");
        final CharSequence[] items = { "Tomar Foto", "Abrir Galeria", "Cancelar" };

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(UXRG.this);
        builder.setTitle("Agregar Foto");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Tomar Foto")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Abrir Galeria")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Seleccionar Archivo"),
                            SELECT_FILE);
                } else if (items[item].equals("Cancelar")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE){
                X714827718(data);
            }else if (requestCode == REQUEST_CAMERA){
                X714827717(data);
            }
        }
    }

    private void X714827717(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        assert thumbnail != null;
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        String file = XP3243XJX + "F50012.jpg";

        FileOutputStream fo;
        try {
            fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());
            fo.close();
            im.setText("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void X714827718(Intent data) {
        X99099 xCopyFile = new X99099(this);
        Uri selectedImageUri = data.getData();
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(selectedImageUri, projection, null, null, null);
        int column_index = cursor != null ? cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA) : 0;
        if (cursor != null) { cursor.moveToFirst(); }
        String selectedImagePath = cursor != null ? cursor.getString(column_index) : null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 200;
        int scale = 1;
        while (options.outWidth / scale / 2 >= REQUIRED_SIZE && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        File f = new File(XP3243XJX + "F50012.jpg");

        try {
            if (selectedImagePath != null) {
                xCopyFile.X184426110(new File(selectedImagePath), f);
            }
            im.setText("1");
            if (cursor != null) { cursor.close(); }
        } catch (IOException e) { e.printStackTrace(); }
    }
    /** UPLOAD IMAGE FIN **************************************************************************/

}
