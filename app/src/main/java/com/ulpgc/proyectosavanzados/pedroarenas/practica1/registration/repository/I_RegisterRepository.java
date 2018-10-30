package com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.repository;

public interface I_RegisterRepository {

    void login (String email, String pasword);
    void forgotPass(String email);

}
