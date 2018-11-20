package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.presenter;


import android.util.Log;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.interactor.LoginIteractor;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.view.LoginActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class LoginPresenter implements I_LoginPresenter {
    private LoginIteractor iteractor;
    private LoginActivity viewLogin;


    private EventBus eventBus;

    public LoginPresenter(LoginActivity loginActivity) {
        Log.d("AUTENTICATION","LoginPresenter");
        iteractor = new LoginIteractor();
        this.viewLogin = loginActivity;
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
    @Subscribe
    public void onEventLoginThread(LoginEvent event) {

        switch (event.getEventType()) {
            case LoginEvent.SUCCESS_LOG_IN:
                viewLogin.giveAccess();
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

                break;
            case LoginEvent.SUCCESS_ALTA:
                break;
        }
    }



    public void dataFromViewLogin(String mail, String password) {
        Log.d("AUTENTICATION","LoginDataUser");
        iteractor.checkUserIdentification(mail, password);
    }


    public void dataFromViewRegister(String name, String mail, String pass) {
        Log.d("AUTENTICATION","LoginDataUser");
        iteractor.checkUserRegistration(mail,pass);
        iteractor.saveUserOnDB(name,mail,pass);
    }


}
