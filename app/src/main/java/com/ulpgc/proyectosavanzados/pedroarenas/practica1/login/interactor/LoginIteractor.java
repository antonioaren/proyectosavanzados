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
    public void checkUserRegistration(String mail, String password) {
        repository.singIn(mail, password);
    }

    @Override
    public void saveUserOnDB(String name, String mail, String pass) {
        repository.saveOnDB(name, mail, pass);
    }
}
