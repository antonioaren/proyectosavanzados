package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.interactor;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.repository.DashboardRepository;

public class DashboardInteractor implements I_DashboardInteractor {

    private DashboardRepository repository;

    public DashboardInteractor() {
        repository = new DashboardRepository();
    }

    public void loadData(String email) {
        repository.loadData(email);

    }
}
