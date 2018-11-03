package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.interactor;

public interface I_LoginInteractor {
    void checkUserIdentification(String mail, String password);

    void checkUseRegistration(String mail, String password);
}
