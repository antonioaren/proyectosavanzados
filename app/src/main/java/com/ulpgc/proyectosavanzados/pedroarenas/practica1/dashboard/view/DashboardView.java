package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.R;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.presenter.DashboardPresenter;

public class DashboardView extends AppCompatActivity implements I_DashboardView {

    private EditText id;
    private EditText nombre;
    private EditText correo;

    private Button update;
    private Button delete;
    private Button logOut;

    private DashboardPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        presenter = new DashboardPresenter(this);

        Intent intent = getIntent();
        intent.getStringExtra("Email");

        id =  findViewById(R.id.idDash);
        correo = findViewById(R.id.mailDash);
        nombre = findViewById(R.id.nameDash);

        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        logOut = findViewById(R.id.logout);

        loadData(intent.getStringExtra("Email"));

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void loadData(String email) {
        presenter.loadData(email);
    }

    @Override
    public void showToast() {

    }
}
