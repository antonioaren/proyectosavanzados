package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.R;

public class DashboardView extends AppCompatActivity implements I_DashboardView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }
}
