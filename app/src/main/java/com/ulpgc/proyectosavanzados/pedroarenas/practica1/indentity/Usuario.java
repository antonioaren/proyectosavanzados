package com.ulpgc.proyectosavanzados.pedroarenas.practica1.indentity;

public class Usuario {

    private String ID;
    private String name;
    private String email;

    public Usuario(String ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }

    public Usuario() {
        
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
