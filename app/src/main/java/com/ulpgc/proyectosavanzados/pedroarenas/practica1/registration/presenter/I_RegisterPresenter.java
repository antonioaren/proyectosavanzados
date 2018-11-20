package com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.presenter;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

public interface I_RegisterPresenter {
    void onStart();

    void onStop();

    void onEventLoginThread(LoginEvent event);
}
