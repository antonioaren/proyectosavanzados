package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.presenter;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

public interface I_LoginPresenter {
    void onStart();

    void onStop();

    void onEventLoginThread(LoginEvent event);


}
