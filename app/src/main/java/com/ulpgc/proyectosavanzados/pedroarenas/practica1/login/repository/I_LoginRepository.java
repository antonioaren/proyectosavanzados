package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.repository;

public interface I_LoginRepository {

    void singUp (String email, String password);

    void singIn(String email, String password);

    void forgotPass (String email);
}
