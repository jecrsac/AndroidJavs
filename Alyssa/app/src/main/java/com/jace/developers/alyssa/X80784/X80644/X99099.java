package com.jace.developers.alyssa.X80784.X80644;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X87625.X77940;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *@access       public
 *@author       Javier Eduardo Ceron Rangel
 *@version      20160801-001
 *@package      xHP | Movil
 *@copyright    Cibox Smart Solutions S.A. de C.V.
 */


public class X99099 {

    Context c;
    public X99099(Context context) { c = context; }

    /** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ FUNCIONES - INI */
    private String X117130560(String... arguments){
        String a1151270166 = arguments[0]; /* Original */
        String b1151270166 = arguments[1]; /* Longitud */
        String c1151270166 = arguments[2]; /* Char */
        int d1151270166 = Integer.parseInt(b1151270166) - a1151270166.length();

        String e1151270166 = "";
        for(int x=0;x<d1151270166;x++){ e1151270166+=c1151270166; }
        e1151270166+=a1151270166;

        return e1151270166;
    }

    private String X334465425(String... arguments){
        String x88000 = arguments[0]; /* String */
        String x89500;

        Random x98600 = new Random(); /* Objeto Random */
        Date x12267 = new Date();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95100 = new SimpleDateFormat("mm");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95101 = new SimpleDateFormat("ss");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95102 = new SimpleDateFormat("dd");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95103 = new SimpleDateFormat("hh");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95104 = new SimpleDateFormat("yy");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95105 = new SimpleDateFormat("MM");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95106 = new SimpleDateFormat("S");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat x95107 = new SimpleDateFormat("D");

        switch (x88000.toLowerCase()){
            case "tkn":
                String x1118262258=(char) ((char)x98600.nextInt(122-97+1)+97)+x95100.format(x12267)+x95101.format(x12267)+(x98600.nextInt(9 + 1))+x95102.format(x12267)+((char) ((char)x98600.nextInt(122-97+1)+97))+x95103.format(x12267)+x95104.format(x12267);
                String x1118262259=(char) ((char)x98600.nextInt(57-48+1)+48)+x95105.format(x12267)+((char) ((char)x98600.nextInt(122-97+1)+97))+x95101.format(x12267)+(char) ((char)x98600.nextInt(122-97+1)+97);
                x89500=(x1118262258+x1118262259);
                break;
            case "nkn":
                x89500 = (x98600.nextInt(9 + 1))+X117130560(Integer.toString((x98600.nextInt((Integer.parseInt(x95106.format(x12267)))))), "3", Integer.toString(x98600.nextInt(9 + 1)))+x95106.format(x12267)+X117130560(Integer.toString((x98600.nextInt((Integer.parseInt(x95106.format(x12267)))))), "3", Integer.toString(x98600.nextInt(9 + 1)));
                break;
            case "dkn":/* Random - Año - Dia - i - s  */
                // x89500 = Integer.toString(x98600.nextInt(9 + 1));
                x89500 = (x98600.nextInt(9 + 1))+x95104.format(x12267)+X117130560(Integer.toString((x98600.nextInt((Integer.parseInt(x95106.format(x12267))) + 1))), "3", "0");
                x89500+= (x95100.format(x12267)+x95101.format(x12267));
                x89500+= X117130560(Integer.toString(x98600.nextInt(Integer.parseInt(x95107.format(x12267)))), "3", Integer.toString(x98600.nextInt(9 + 1)));
                x89500+= X117130560(Integer.toString((x98600.nextInt(99 + 1))), "2", Integer.toString(x98600.nextInt(9 + 1)));
                break;
            case "fkn":
                x89500 = (x98600.nextInt(9 + 1))+x95101.format(x12267)+x95100.format(x12267);
                break;
            default:
                UUID uuid = UUID.randomUUID();
                x89500 = uuid.toString();
                break;
        }

        return x89500;
    }

    public interface AsyncResponse {
        void processFinish(List<X77940> X88000);
    }

    public boolean X165008670(String... arguments){
        String x88000 = arguments[0]; /* String */

        File path = Environment.getExternalStorageDirectory();
        String save_path = path.toString() + x88000;
        File newFile=new File(save_path);
        return newFile.mkdirs();
    }

    public String X165008671(){
        File path = Environment.getExternalStorageDirectory();
        return path.toString();
    }

    public void X184426110(File sourceFile, File destFile) throws IOException {
        FileChannel source, destination;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (source != null) { destination.transferFrom(source, 0, source.size()); }
        if (source != null) { source.close(); }
        destination.close();
    }

    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setIcon((status) ? R.drawable.success : R.drawable.fail)
                .setNegativeButton("Close",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    /** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ FUNCIONES - FIN */

    /** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ALIAS - INI */
    public String xADDCH(String... arguments){
        String a1151270166 = arguments[0]; /* Original */
        String b1151270166 = arguments[1]; /* Longitud */
        String c1151270166 = arguments[2]; /* Char */
        return X117130560(a1151270166, b1151270166, c1151270166);
    }

    public String xAKN(String... arguments){
        String x88000 = arguments[0]; /* String */
        return X334465425(x88000);
    }
    /** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ALIAS - FIN */
}
