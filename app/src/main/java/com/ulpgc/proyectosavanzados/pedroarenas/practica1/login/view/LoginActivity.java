package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.R;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view.DashboardView;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.presenter.LoginPresenter;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.view.RegisterView;

public class LoginActivity extends AppCompatActivity implements I_LoginActivity {

    private LoginPresenter presenter;



    private Button buttonSingIn;
    private Button buttonRegister;
    private EditText correo;
    private EditText pass;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        Log.d("AUTENTICATION","OnCreate");
        presenter = new LoginPresenter(this);


        correo = (EditText) findViewById(R.id.mail);
        pass = (EditText) findViewById(R.id.password);
        this.buttonSingIn = (Button) findViewById(R.id.buttonSignIn);
        this.buttonRegister = (Button) findViewById(R.id.buttonRegister);
        this.loading =(ProgressBar) findViewById(R.id.login_loading);



        this.buttonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToPresenter();
            }
        });
        this.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegistration();
            }
        });



        correo.setText("antonioaren@hotmail.com");
        pass.setText("pedro1234");


    }

    @Override
    protected void onResume() {
        super.onResume();

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
    public void sendDataToPresenter() {
        Log.d("AUTENTICATION","sendDataToPresenter");
        //TODO: Falta validación del texto. (Presenter)

        presenter.dataFromViewLogin(correo.getText().toString(), pass.getText().toString());
        loading.setVisibility(View.VISIBLE);
    }


    public void giveAccess(String email) {
        Intent intent = new Intent(this, DashboardView.class);
        intent.putExtra("Email", email);

        loading.setVisibility(View.INVISIBLE);
        this.showToast("Login Correcto");

        startActivity(intent);
        finish();
    }

    public void goToRegistration () {
        onStop();
        Intent intent = new Intent(this, RegisterView.class);
        startActivity(intent);
    }

    public void setDataFromRegistration () {

    }

    @Override
    public void disableProgressBarBecauseOfError() {
        loading.setVisibility(View.INVISIBLE);
    }



    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }


    @Override
    public void limpiarFormulario() {
        correo.setText("");
        pass.setText("");
    }
}
