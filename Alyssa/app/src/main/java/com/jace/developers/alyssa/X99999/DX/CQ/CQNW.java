package com.jace.developers.alyssa.X99999.DX.CQ;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X51827;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X86082.X86082;
import com.jace.developers.alyssa.X99999.DG.DGCQ;
import com.jace.developers.alyssa.X99999.DG.DGSN;
import com.jace.developers.alyssa.X99999.DG.DGTS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class CQNW extends AppCompatActivity implements DGTS.X113925003, DGCQ.X171001000, DGSN.X171001000 {

    X86082 XCFG = new X86082();
    X99099 XJCX = new X99099(this);

    String XDAT, IXSN, XBIN, XYU8EBGS8, XR4HN3I66, XCYQRAWJC, XP3243XJX;

    ProgressDialog pDialog;
    View XN1ZYMJVW;

    private static final int MY_WRITE_EXTERNAL_STORAGE = 0;
    private static final int CAMERA_REQUEST = 1;

    int SCRNW=0, SCRNH=0;

    private int XASZ4XP1F=0;
    private int XBOH9N61X;
    private int YBOH9N61Y;

    boolean XOHKEDE6P = false;
    boolean XRQ0B44VI = false;
    boolean XF0UH3M9L = false;
    boolean goma = false;

    private View XNT8BZJ4C;
    private ViewGroup XOV2MT9JD;
    private Paint XJVI6QJAX;
    private ImageView v;
    File file;

    LinearLayout XEN72P88E, XX60FOK90, XEZ2A30DG;

    private Matrix matrix = new Matrix();
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private static final int DELT = 3;
    private int mode = NONE;

    private int rotateAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dx_createcroq);

        XCFG = (X86082) getApplicationContext();
        XDAT = XCFG.GXDAT();/** URL DAT **/
        XBIN = XCFG.GXBIN();/** URL BIN **/
        IXSN = XCFG.GBF00();/** IX  SIN **/

        XR4HN3I66=XJCX.xAKN("DKN")+".png";

        /** PERMISSION **/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_WRITE_EXTERNAL_STORAGE);
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
            }
        }

        XP3243XJX = XJCX.X165008671()+"/Alyssa/Croquis/"+IXSN+"/";

        /** LAYOUT **/
        XNT8BZJ4C/**   Layout ScreenShot  **/= findViewById(R.id.main);
        XOV2MT9JD/**      Layout Drawing  **/= (ViewGroup)findViewById(R.id.cbxdraw);
        XEN72P88E/** Layout Tool Drawing  **/= (LinearLayout) findViewById(R.id.toolbarDraw);
        XX60FOK90/**    Layout Tool Drag  **/= (LinearLayout)findViewById(R.id.toolbarDrag);
        XEZ2A30DG/**  Layout Tool Rotate  **/= (LinearLayout)findViewById(R.id.XRULPLZSX);

        XN1ZYMJVW = new DrawingView(this);
        XOV2MT9JD.addView(XN1ZYMJVW, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        SCRNW=XNT8BZJ4C.getWidth();
        SCRNH=XNT8BZJ4C.getHeight();


        /** TOOLBAR **/
        ImageButton T72890/**    Button Mover Objeto **/= (ImageButton) findViewById(R.id.btnMove);
        ImageButton T72891/** Button Insertar Objeto **/= (ImageButton) findViewById(R.id.btnObjeto);
        ImageButton T72892/**  Button Activar Dibujo **/= (ImageButton) findViewById(R.id.btnDraw);
        ImageButton T72893/**      Button ScreenShot **/= (ImageButton) findViewById(R.id.capturapant);
        ImageButton T72894/**  Button Insertar Cruce **/= (ImageButton) findViewById(R.id.btnCroq);

        /** TOOLBAR DRAW **/
        //ImageButton DW_T72890/**   Button Dibujar Linea **/= (ImageButton) findViewById(R.id.btnDrawLine);
        ImageButton DW_T72891/**    Button Dibujar Free **/= (ImageButton) findViewById(R.id.btnDrawPaint);
        ImageButton DW_T72892/**          Button Borrar **/= (ImageButton) findViewById(R.id.btnerase);

        /** TOOLBAR DRAG **/
        ImageButton DG_T72890/**         Button Actores **/= (ImageButton) findViewById(R.id.btnDragAct);
        ImageButton DG_T72891/**   Button Señalamientos **/= (ImageButton) findViewById(R.id.btnDragSen);
        ImageButton DG_T72892/**    Button Trayectorias **/= (ImageButton) findViewById(R.id.btnDragTra);
        ImageButton DG_T72893/**        Button Eliminar **/= (ImageButton) findViewById(R.id.btnDragDel);
        // ImageButton DG_T72894/**        Button Bloquear **/= (ImageButton) findViewById(R.id.btnDragLok);


    /** ###########################################################################  INI ACTIONS **/
        if (T72890 != null) {/* Activar Mover */
            T72890.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XOHKEDE6P = true;
                    XJVI6QJAX.setColor(Color.TRANSPARENT);
                    XEN72P88E.setVisibility(View.GONE);
                    XX60FOK90.setVisibility(View.GONE);
                    XEZ2A30DG.setVisibility(View.VISIBLE);
                }
            });
        }

        if (T72891 != null) {/* Activar Objetos */
            T72891.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XOHKEDE6P = false;
                    XJVI6QJAX.setColor(Color.TRANSPARENT);
                    XEN72P88E.setVisibility(View.GONE);
                    XX60FOK90.setVisibility(View.VISIBLE);
                    XEZ2A30DG.setVisibility(View.GONE);
                }
            });
        }

        if (T72892 != null) {/* Activar Dibujo */
            T72892.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XOHKEDE6P = false;
                    XJVI6QJAX.setColor(Color.TRANSPARENT);
                    XX60FOK90.setVisibility(View.GONE);
                    XEN72P88E.setVisibility(View.VISIBLE);
                    XEZ2A30DG.setVisibility(View.GONE);
                }
            });
        }

        if (T72894 != null) {/* Cruces */
            T72894.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //XCYQRAWJC="316189231158519";
                    //DGTS dialogFragment = DGTS.newInstance(XCYQRAWJC);
                    XCYQRAWJC="216189232360915";
                    DGCQ dialogFragment = DGCQ.newInstance(XCYQRAWJC);
                    dialogFragment.show(getSupportFragmentManager(), "Tipo");
                }
            });
        }

        if (T72893 != null) {/* ScreenShot */
            T72893.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XEZ2A30DG.setVisibility(View.GONE);
                    XNT8BZJ4C.setDrawingCacheEnabled(true);
                    Bitmap b = XNT8BZJ4C.getDrawingCache();
                    file = new File(XP3243XJX + XR4HN3I66);

                    try {
                        file.createNewFile();
                        OutputStream os = new FileOutputStream(file);
                        b.compress(Bitmap.CompressFormat.PNG, 90, os);
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    XNT8BZJ4C.setDrawingCacheEnabled(false);
                    // serverUpdate();

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(CQNW.this);
                    builder1.setMessage("ELIGE UNA ACCION A REALIZAR");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "SUBIR CROQUIS",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    serverUpdate();
                                }
                            });

                    builder1.setNegativeButton(
                            "NUEVO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent i = new Intent(CQNW.this, CQNW.class);
                                    startActivity(i);
                                }
                            });

                    builder1.setNeutralButton("SALIR",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent i = new Intent(CQNW.this, CQCT.class);
                            startActivity(i);
                        }
                    });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                }
            });
        }


        /** Draw **/
        if(DW_T72891 != null){/* Draw-Paint */
            DW_T72891.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XJVI6QJAX.setXfermode(null);
                    XJVI6QJAX.setStrokeWidth(6);
                    XJVI6QJAX.setColor(Color.BLACK);
                    XRQ0B44VI=true;
                    XF0UH3M9L=false;
                }
            });
        }

        if(DW_T72892 != null){/* Draw-Erase */
            DW_T72892.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XF0UH3M9L=false;
                    goma=true;
                    XJVI6QJAX.setStrokeWidth(50);
                    XJVI6QJAX.setAlpha(0xFF);//transperent color
                    XJVI6QJAX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    XRQ0B44VI=true;
                }
            });
        }


        /** Drag **/
        if (DG_T72890 != null) {/* Actores */
            DG_T72890.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XCYQRAWJC="716178550314738";
                    DGTS dialogFragment = DGTS.newInstance(XCYQRAWJC);
                    dialogFragment.show(getSupportFragmentManager(), "Tipo");
                    //onOpenDialogSen(v);
                }
            });
        }

        if (DG_T72891 != null) {/* Señalamientos */
            DG_T72891.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XCYQRAWJC="216178544300441";
                    DGTS dialogFragment = DGTS.newInstance(XCYQRAWJC);
                    dialogFragment.show(getSupportFragmentManager(), "Tipo");
                    //onOpenDialogSen(v);
                }
            });
        }

        if (DG_T72892 != null) {/* Trayectorias */
            DG_T72892.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XCYQRAWJC="216182294558683";
                    DGSN dialogFragment = DGSN.newInstance(XCYQRAWJC);
                    dialogFragment.show(getSupportFragmentManager(), "Tipo");
                    //onOpenDialogSen(v);
                }
            });
        }

        if (DG_T72893 != null){/* Eliminar */
            DG_T72893.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mode = DELT;
                    if (v!=null){
                        v.setVisibility(View.GONE);
                    }
                }
            });
        }


        XJVI6QJAX = new Paint();
        XJVI6QJAX.setAntiAlias(true);
        XJVI6QJAX.setDither(true);
        XJVI6QJAX.setColor(Color.TRANSPARENT);
        XJVI6QJAX.setStyle(Paint.Style.STROKE);
        XJVI6QJAX.setStrokeJoin(Paint.Join.ROUND);
        XJVI6QJAX.setStrokeCap(Paint.Cap.ROUND);
        XJVI6QJAX.setStrokeWidth(6);

        Button left10 = (Button) findViewById(R.id.left10);
        Button rooriginal = (Button) findViewById(R.id.rooriginal);
        Button right10 = (Button) findViewById(R.id.right10);

        left10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateAngle -=5;
                rotateAngle %= 360;
                v.setDrawingCacheEnabled(true);
                Bitmap bitmap = v.getDrawingCache();
                v.setImageBitmap(rotate(bitmap));
            }
        });

        rooriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateAngle =0;
                rotateAngle %= 360;
                v.setDrawingCacheEnabled(true);
                Bitmap bitmap = v.getDrawingCache();
                v.setImageBitmap(rotate(bitmap));
            }
        });


        right10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateAngle +=5;
                rotateAngle %= 360;
                v.setDrawingCacheEnabled(true);
                Bitmap bitmap = v.getDrawingCache();
                v.setImageBitmap(rotate(bitmap));
            }
        });

    /** ###########################################################################  FIN ACTIONS **/
    }

    @Override
    public void onSelectedTipo(String XG14ESSIX, String XG14ESSNO) {
        //TPIX.setText(XG14ESSIX);
        //ASTP.setText(XG14ESSNO);
        DGSN dialogFragment = DGSN.newInstance(XG14ESSIX);
        dialogFragment.show(getSupportFragmentManager(), "Tipo");
    }

    @Override
    public void onSelectedSenalamiento(String XG14ESSIX, String XG14ESSNO) {
        new X918710190().execute(XG14ESSNO);
    }


    private class X918710190 extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap ximagen = null;
            int IW, IH;
            switch (XCYQRAWJC) {
                case "716178550314738":
                    IW = 200;
                    IH = 200;
                    break;
                case "216189232360915":
                    IW = SCRNW;
                    IH = SCRNH;
                    break;
                default:
                    IW = 110;
                    IH = 110;
                    break;
            }

            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                ximagen = BitmapFactory.decodeStream(in);
                ximagen = Bitmap.createScaledBitmap(ximagen, IW, IH, true);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return ximagen;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CQNW.this);
            pDialog.setMessage("Cargando Imagen...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap ximagen) {
            if (!XCYQRAWJC.equals("216189232360915")){
                pDialog.dismiss();
                mode = DRAG;
                XYU8EBGS8 = XJCX.xAKN("FKN");
                // Random rnd = new Random();
                // int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                ImageView XH6NLW28X = new ImageView(CQNW.this);
                XH6NLW28X.setId(Integer.parseInt(XYU8EBGS8));
                XH6NLW28X.setImageBitmap(ximagen);
                //XH6NLW28X.setBackgroundColor(color);
                XH6NLW28X.setScaleType(ImageView.ScaleType.MATRIX);
                XH6NLW28X.setImageMatrix(matrix);
                XH6NLW28X.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        v = (ImageView) view;
                        final int X = (int) event.getRawX();
                        final int Y = (int) event.getRawY();

                        int action = event.getAction() & MotionEvent.ACTION_MASK;

                        switch (action){
                            case MotionEvent.ACTION_DOWN:
                                XASZ4XP1F=view.getId();
                                Log.d("ID","Name "+XASZ4XP1F);
                                if (XASZ4XP1F != 0) {
                                    RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                                    XBOH9N61X = X - Params.leftMargin;
                                    YBOH9N61Y = Y - Params.topMargin;
                                    mode = DRAG;
                                    view.bringToFront();
                                    view.invalidate();
                                }
                                break;

                            case MotionEvent.ACTION_POINTER_DOWN:
                                break;

                            case MotionEvent.ACTION_MOVE:
                                if (mode == DRAG) {
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                                    layoutParams.leftMargin = X - XBOH9N61X;
                                    layoutParams.topMargin = Y - YBOH9N61Y;
                                    layoutParams.rightMargin =(int) getResources().getDimension(R.dimen.f88104);
                                    layoutParams.bottomMargin =(int) getResources().getDimension(R.dimen.f88104);
                                    view.setLayoutParams(layoutParams);
                                    view.invalidate();
                                } else if (mode == ZOOM) {
                                    if (XASZ4XP1F==v.getId()){
                                        rotateAngle +=10;
                                        rotateAngle %= 360;
                                    }
                                }
                                break;

                            case MotionEvent.ACTION_UP:
                            case MotionEvent.ACTION_POINTER_UP:
                                mode = NONE;
                                XASZ4XP1F=0;
                                view.invalidate();
                                break;

                        }
                        v.setImageMatrix(matrix);
                        return true;
                    }
                });
                XOV2MT9JD.addView(XH6NLW28X);
            }else{
                pDialog.dismiss();
                BitmapDrawable background = new BitmapDrawable(getApplicationContext().getResources(),ximagen);
                background.setAlpha(190);
                XNT8BZJ4C.setBackground(background);
            }
        }
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        if ( pDialog!=null && pDialog.isShowing() ){
            pDialog.dismiss();
        }
    }

    /** #########################################################################  INI FUNCTIONS **/
    public class DrawingView extends View {
        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;
        ArrayList<Line> lines = new ArrayList<>();

        public DrawingView(Context c) {
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setDither(true);
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath( mPath,  XJVI6QJAX);
            canvas.drawPath( circlePath,  circlePaint);
            for (Line l : lines) {
                canvas.drawLine(l.startX, l.startY, l.stopX, l.stopY, XJVI6QJAX);
                if (goma)
                    canvas.drawLine(0, 0, 0, 0, XJVI6QJAX);
            }
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
        }

        private void touch_move(float x, float y) {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;

                circlePath.reset();
                circlePath.addCircle(mX, mY, 30, Path.Direction.CW);
            }
        }

        private void touch_up() {
            mPath.lineTo(mX, mY);
            circlePath.reset();
            // commit the path to our offscreen
            mCanvas.drawPath(mPath,  XJVI6QJAX);
            // kill this so we don't double draw
            mPath.reset();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (XF0UH3M9L){
                        lines.add(new Line(event.getX(), event.getY()));
                    }else{
                        touch_start(x, y);
                    }
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (XF0UH3M9L){
                        if (lines.size() > 0){
                            Line current = lines.get(lines.size() - 1);
                            current.stopX = event.getX();
                            current.stopY = event.getY();
                        }
                    }else {
                        touch_move(x, y);
                    }
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    if (XF0UH3M9L){
                        if (lines.size() > 0){
                            Line current = lines.get(lines.size() - 1);
                            current.stopX = event.getX();
                            current.stopY = event.getY();
                        }
                    }else {
                        touch_up();
                    }
                    invalidate();
                    break;
            }
            return true;
        }
    }

    class Line {
        float startX, startY, stopX, stopY;
        Line(float startX, float startY, float stopX, float stopY) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
        }
        Line(float startX, float startY) { // for convenience
            this(startX, startY, startX, startY);
        }
    }

    public Bitmap rotate(Bitmap paramBitmap) {
        if (rotateAngle% 360 == 0) {
            return paramBitmap;
        }
        Matrix localMatrix = new Matrix();
        float f1 = paramBitmap.getWidth() / 2;
        float f2 = paramBitmap.getHeight() / 2;
        localMatrix.postTranslate(-paramBitmap.getWidth() / 2, -paramBitmap.getHeight() / 2);
        localMatrix.postRotate(rotateAngle);
        localMatrix.postTranslate(f1, f2);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        new Canvas(paramBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
        return paramBitmap;
    }

    private void serverUpdate(){
        if (file.exists()){ new ServerUpdate().execute(); }else{ XJCX.showAlertDialog(CQNW.this,"Alyssa", "ERROR AL SUBIR LA IMAGEN", false); }
    }

    class ServerUpdate extends AsyncTask<String,String,String> {

        ProgressDialog pDGL;
        @Override
        protected String doInBackground(String... arg0) {
            uploadFile(XP3243XJX + XR4HN3I66);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    XJCX.showAlertDialog(CQNW.this,"Alyssa", "EXITO AL SUBIR LA IMAGEN", true);
                    Intent i = new Intent(CQNW.this, CQCT.class);
                    startActivity(i);
                }
            });

            return null;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            pDGL = new ProgressDialog(CQNW.this);
            pDGL.setMessage("Subiendo Imagen, espere..." );
            pDGL.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDGL.setCancelable(false);
            pDGL.show();
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pDGL.dismiss();
        }
    }

    public void uploadFile(String filename){
        try {
            FileInputStream fis = new FileInputStream(filename);
            X51827 htfu = new X51827(XBIN+"?CR="+XCFG.GBF00()+"&TP=90892","noparamshere", filename);
            htfu.doStart(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(CQNW.this, CQCT.class);
        startActivity(i);
    }
    /** #########################################################################  FIN FUNCTIONS **/

}
