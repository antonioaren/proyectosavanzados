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

    public void deleteData(String id) {
        repository.deleteData(id);
    }

    public void updateData(String id, String newName) {
        repository.updateData(id, newName);
    }

    public void logOut () {
        repository.logOut();
    }
}
