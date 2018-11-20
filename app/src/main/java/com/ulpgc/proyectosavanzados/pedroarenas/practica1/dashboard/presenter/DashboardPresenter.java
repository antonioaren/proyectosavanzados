package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.presenter;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view.DashboardView;

public class DashboardPresenter implements  I_DashboardPresenter {

    private DashboardView view;

    public DashboardPresenter(DashboardView dashboardView) {
        this.view = dashboardView;
    }
}
