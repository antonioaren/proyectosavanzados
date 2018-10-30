package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.R;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view.DashboardView;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.view.RegisterView;

public class LoginActivity extends AppCompatActivity implements I_LoginActivity {


    private FirebaseAuth mAuth;
    private Button buttonSingIn;
    private EditText correo;
    private EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        correo = (EditText) findViewById(R.id.mail);
        contraseña = (EditText) findViewById(R.id.password);
        buttonSingIn = (Button) findViewById(R.id.button);

        buttonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
            }
        });


        mAuth = FirebaseAuth.getInstance();
    }

    private void checkUser() {
        correo.getText();
        contraseña.getText();
    }

    @Override
    public void giveAccess() {
        Intent intent = new Intent(this, DashboardView.class);
        startActivity(intent);
        //finish();
    }

    @Override
    public void registration () {
        Intent intent = new Intent(this, RegisterView.class);
        finish();
    }









}
