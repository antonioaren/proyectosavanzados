package com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.presenter;

import android.util.Log;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.interactor.RegisterIteractor;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.view.RegisterView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class RegisterPresenter implements I_RegisterPresenter {

    private RegisterIteractor iteractor;
    private RegisterView viewLogin;

    private EventBus eventBus;

    public RegisterPresenter(RegisterView registerActivity) {
        Log.d("AUTENTICATION","RegisterPresenter");
        iteractor = new RegisterIteractor();
        this.viewLogin = registerActivity;
        this.eventBus = EventBus.getDefault();
    }


    @Override
    public void onStart() {
        String text = "Hola";
        eventBus.register(this); //ESTE ES EL ERROR

    }

    @Override
    public void onStop() {
        viewLogin = null;
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventLoginThread(LoginEvent event) {
        switch (event.getEventType()) {
            case LoginEvent.SUCCESS_LOG_IN:
                //viewLogin.giveAccess();
                break;
            case LoginEvent.ERROR_LOG_IN:
                viewLogin.showToast("ERROR AL VALIDAR. REVISAR CONTRASEÑA");
                viewLogin.limpiarFormulario();

                break;
            case LoginEvent.SUCCESS_RESET_PASSWORD:
                //view.mostrarResetearContrasenaEnviada();
                break;
            case LoginEvent.ERROR_RESET_PASSWORD:
                // view.mostrarErrorResetearContrasena();
                viewLogin.limpiarFormulario();
                break;
            case LoginEvent.ERROR_ALTA:
                viewLogin.showToast("Error al registrar");
                break;
            case LoginEvent.SUCCESS_ALTA:
                viewLogin.showToast("User Registered");
                viewLogin.goToLogin();
                break;
        }
    }





    public void registerDataUser(String mail, String password) {
        iteractor.checkUserRegistration(mail, password);

    }
}
