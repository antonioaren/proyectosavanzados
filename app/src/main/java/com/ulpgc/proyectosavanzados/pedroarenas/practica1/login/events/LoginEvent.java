package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events;

public class LoginEvent {
    public static final int ERROR_LOG_IN = 0;
    public static final int SUCCESS_LOG_IN = 1;
    public static final int ERROR_RESET_PASSWORD = 2;
    public static final int SUCCESS_RESET_PASSWORD = 3;
    public static final int ERROR_ALTA = 4;
    public static final int SUCCESS_ALTA = 5;
    public static final int SUCCESS_DATA_GET_FROM_DB = 6;
    public static final int FAIL_DATA_GET_FROM_DB = 7;


    private int eventType;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
