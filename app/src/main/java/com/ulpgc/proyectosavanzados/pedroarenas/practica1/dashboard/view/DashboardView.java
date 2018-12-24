package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.R;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.presenter.DashboardPresenter;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.indentity.Usuario;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.view.LoginActivity;

public class DashboardView extends AppCompatActivity implements I_DashboardView {

    private EditText id;
    private EditText nombre;
    private EditText correo;

    private Button update;
    private Button delete;
    private Button logOut;

    private DashboardPresenter presenter;
    private String TAG = this.getClass().getName();


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

        id.setEnabled(false);
        correo.setEnabled(false);


        loadData(intent.getStringExtra("Email"));

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {presenter.updateName(id.getText().toString(), nombre.getText().toString());}
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.deleteAccount(id.getText().toString());
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.logOut();
            }
        });
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
    public void backToLogin() {
        onStop();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loadData(String email) {
        presenter.loadData(email);
    }

    @Override
    public void setData(Usuario usuario ) {
        Log.d(TAG, "setData");
        id.setText(usuario.getID());
        correo.setText(usuario.getEmail());
        nombre.setText(usuario.getName());
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
