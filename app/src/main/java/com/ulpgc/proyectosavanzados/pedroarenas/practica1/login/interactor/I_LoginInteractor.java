package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.interactor;

public interface I_LoginInteractor {
    void checkUserIdentification(String mail, String password);

    void checkUserRegistration(String mail, String password);

    void saveUserOnDB(String name, String mail, String pass);
}
