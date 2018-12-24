package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.presenter;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

import org.greenrobot.eventbus.Subscribe;

interface I_DashboardPresenter {
    void onStart();

    void onStop();

    @Subscribe
    void onEventLoginThread(LoginEvent event);

    void loadData(String email);

    void updateName(String id, String newName);

    void logOut();

    void deleteAccount(String id);
}
