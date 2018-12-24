package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.indentity.Usuario;

interface I_DashboardView {

    void backToLogin();

    public void loadData(String email);

    void setData(Usuario usuario);

    public void showToast(String error_al_cargar_los_datos);


}
