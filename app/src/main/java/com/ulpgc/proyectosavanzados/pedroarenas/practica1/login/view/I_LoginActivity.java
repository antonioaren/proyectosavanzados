package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.view;

public interface I_LoginActivity {


    void sendDataToPresenter();

    void disableProgressBarBecauseOfError();

    void showToast(String text);

    void limpiarFormulario();
}
