package com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.presenter;

import android.util.Log;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.interactor.LoginIteractor;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.presenter.I_LoginPresenter;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.view.RegisterView;

import org.greenrobot.eventbus.EventBus;

public class RegisterPresenter implements I_LoginPresenter {

    private LoginIteractor iteractor;
    private RegisterView viewLogin;

    private EventBus eventBus;

    public RegisterPresenter(RegisterView registerActivity) {
        Log.d("AUTENTICATION","RegisterPresenter");
        iteractor = new LoginIteractor();
        this.viewLogin = registerActivity;
        this.eventBus = EventBus.getDefault();
    }


    @Override
    public void onStart() {
        eventBus.register(this);

    }

    @Override
    public void onStop() {
        viewLogin = null;
        eventBus.unregister(this);
    }

    @Override
    public void onEventLoginThread(LoginEvent event) {

    }





    public void registerDataUser(String mail, String password) {
        iteractor.checkUseRegistration(mail, password);

    }
}
