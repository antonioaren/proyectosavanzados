package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events;

import android.util.Log;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.indentity.Usuario;

public class LoginEvent {

    public static final int ERROR_LOG_IN = 0;
    public static final int SUCCESS_LOG_IN = 1;

    public static final int ERROR_RESET_PASSWORD = 2;
    public static final int SUCCESS_RESET_PASSWORD = 3;

    public static final int ERROR_ALTA = 4;
    public static final int SUCCESS_ALTA = 5;

    public static final int SUCCESS_DATA_GET_FROM_DB = 6;
    public static final int FAIL_DATA_GET_FROM_DB = 7;

    public static final int DELETE_SUCCESS = 8;
    public static final int DELETE_ERROR = 9;

    public static final int UPDATE_SUCCESS = 10;
    public static final int UPDATE_ERROR = 11;

    public static final int LOGOUT_SUCCESS = 12;
    public static final int LOGOUT_ERROR = 13;

    private String TAG = this.getClass().getName();
    private int eventType;
    private Usuario usuario;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        Log.d(TAG, "Obteniendo Usuarios");
        return usuario;
    }
}
