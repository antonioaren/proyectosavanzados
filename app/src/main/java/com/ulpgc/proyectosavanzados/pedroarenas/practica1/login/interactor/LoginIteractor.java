package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.interactor;

import android.util.Log;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.repository.LoginRepository;

public class LoginIteractor implements I_LoginInteractor {
    private LoginRepository repository;



    public LoginIteractor() {
        repository = new LoginRepository();
    }

    @Override
    public void checkUserIdentification(String mail, String password) {
        Log.d("AUTENTICATION","checkUserIdentification");
        repository.singIn(mail,password);
    }

    @Override
    public void checkUseRegistration(String mail, String password) {
        repository.singUp(mail, password);
    }
}
