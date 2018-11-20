package com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.interactor;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.repository.RegisterRepository;

public class RegisterIteractor implements I_RegisterInteractor {
    private RegisterRepository registerRepository;

    public RegisterIteractor() {
        registerRepository = new RegisterRepository();
    }


    public void checkUserRegistration(String name, String mail, String password) {
        registerRepository.signUp(name, mail,password);

    }
}
