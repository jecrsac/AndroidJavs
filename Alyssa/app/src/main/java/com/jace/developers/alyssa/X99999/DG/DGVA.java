package com.jace.developers.alyssa.X99999.DG;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DGVA extends DialogFragment {

    private DGVA.X311603391 mCallback;
    private TextView xFECHA;
    private String xFC;
    X99099 XJCX = new X99099(getContext());


    public DGVA() { }

    public interface X311603391 {
        void onSelectedDateUntil(String XG14ESFXX);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = null;

        if (context instanceof Activity){
            a=(Activity) context;
        }

        try {
            mCallback = (DGVA.X311603391) a;
        }
        catch (ClassCastException e) {
            Log.d("MyDialog", "Activity doesn't implement the ISelectedData interface");
        }

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createLoginDialogo();
    }


    public AlertDialog createLoginDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.dg_dates_a, null);

        xFECHA = (TextView) v.findViewById(R.id.SGFA);
        DatePicker DATE= (DatePicker) v.findViewById(R.id.datePicker2);

        final int day = DATE.getDayOfMonth();
        final int month = DATE.getMonth() + 1;
        final int year = DATE.getYear();
        xFECHA.setText(day+"-"+month+"-"+year);

        Calendar today = Calendar.getInstance();
        DATE.init(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener(){
                    @Override
                    public void onDateChanged(DatePicker view,
                                              int year, int monthOfYear,int dayOfMonth) {
                        xFECHA.setText(XJCX.xADDCH(Integer.toString(dayOfMonth),"2","0")+"-"+XJCX.xADDCH(Integer.toString((monthOfYear + 1)),"2","0")+"-"+year);

                    }});


        builder.setTitle("VIGENCIA");
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.snt_33900_flw, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                xFC = xFECHA.getText().toString();
                mCallback.onSelectedDateUntil(xFC);
                dismiss();
            }
        });
        builder.setView(v);


        return builder.create();
    }
}
