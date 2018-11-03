package com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.R;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.presenter.RegisterPresenter;

public class RegisterView extends AppCompatActivity implements I_RegisterView {
    private EditText name;
    private EditText mail;
    private EditText pass;
    private EditText passRepeated;
    private Button buttonSignUp;

    //private LoginPresenter presenter;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText) findViewById(R.id.editNameR);
        mail = (EditText) findViewById(R.id.editMailR);
        pass = (EditText) findViewById(R.id.editPassR);
        passRepeated = (EditText) findViewById(R.id.editPassRepR);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToPresenter();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void sendDataToPresenter() {
        //name.getText().toString();
        presenter.registerDataUser(mail.getText().toString(),pass.getText().toString());
    }

    @Override
    public void showToast(String text) {
        //TODO: Validaciones y errores a presentar para el registro.

    }

    @Override
    public void limpiarFormulario() {
        //TODO: Me da igual porque destruiré la vista.
    }

    public void goToLogin () {
        //Intent intent = new Intent(this,LoginActivity.class);
        //startActivity(intent);

        finish();

    }



}
