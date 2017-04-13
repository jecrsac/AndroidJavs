package com.jace.developers.alyssa.X99999.CX;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jace.developers.alyssa.R;
import com.jace.developers.alyssa.X80784.X80644.X99099;
import com.jace.developers.alyssa.X80784.X80980.X46161;
import com.jace.developers.alyssa.X86870.X18800;
import com.jace.developers.alyssa.X99999.SX.SXNW;
import com.jace.developers.alyssa.X99999.UX.UXSN;
import com.jace.developers.alyssa.X99999.UX.UXST;

import java.io.File;
import java.sql.SQLException;

import de.hdodenhof.circleimageview.CircleImageView;

public class CXMN extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    X99099 XJCX = new X99099(this);
    X18800 XDBX = new X18800(this);

    String  XFQIJLRNO, XFQIJLREM, XP3243XJX;
    TextView XC3O4FN2R, XPZ3XNC5J;

    PendingIntent pendingIntent;
    LocationManager lm;

    private static final int COARSE_LOCATION_REQUEST = 1;
    private static final int FINE_LOCATION = 2;

    DrawerLayout drawerLayout;
    MenuItem xitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cr_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, COARSE_LOCATION_REQUEST);
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION);
            }
            return;
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        @SuppressLint("InflateParams") View header = LayoutInflater.from(this).inflate(R.layout.cr_nav_header, null);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.addHeaderView(header);
        }


        XP3243XJX = XJCX.X165008671()+"/Alyssa/Perfil/";
        File imgFile = new  File(XP3243XJX+"F50012.jpg");

        XC3O4FN2R = (TextView) header.findViewById(R.id.XEUZKWVJA);
        XPZ3XNC5J = (TextView) header.findViewById(R.id.XIAPR3V7H);

        CircleImageView imageView = (CircleImageView) header.findViewById(R.id.fotoPerfil);
        if(imgFile.exists()){
            Bitmap icon = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(icon);
        }else {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.perfil,null));
        }

        try {
            X833634912();
            XC3O4FN2R.setText(XFQIJLRNO);
            XPZ3XNC5J.setText(XFQIJLREM);
            //XUMJ13C2S.setText(XFQIJLRTL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //---use the LocationManager class to obtain locations data---
        lm = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Intent i = new Intent(getApplicationContext(), X46161.class);
        pendingIntent = PendingIntent.getBroadcast(
                getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        //---request for location updates using GPS---
        lm.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                10000,
                0,
                pendingIntent);


        setFragment(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cxmn, menu);
        xitem = menu.findItem(R.id.action_add);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent i = new Intent (getApplication(), SXNW.class);
                startActivity(i);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_estatus:
                item.setChecked(true);
                setFragment(1);
                drawerLayout.closeDrawer(GravityCompat.START);
                xitem.setVisible(false);
                return true;
            case R.id.nav_siniestro:
                item.setChecked(true);
                setFragment(0);
                drawerLayout.closeDrawer(GravityCompat.START);
                xitem.setVisible(true);
                return true;
        }
        return true;
    }


    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                UXST stsFragment = new UXST();
                fragmentTransaction.replace(R.id.contenedor_principal, stsFragment);
                fragmentTransaction.commit();
                break;
            default:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                UXSN inboxFragment = new UXSN();
                fragmentTransaction.replace(R.id.contenedor_principal, inboxFragment);
                fragmentTransaction.commit();
                break;
        }
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
    }

}
