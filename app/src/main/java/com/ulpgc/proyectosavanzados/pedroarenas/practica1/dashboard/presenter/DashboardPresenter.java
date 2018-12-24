package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.presenter;

import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.interactor.DashboardInteractor;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.view.DashboardView;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class DashboardPresenter implements  I_DashboardPresenter {

    private DashboardView view;
    private DashboardInteractor iterator;
    private EventBus eventBus;

    public DashboardPresenter(DashboardView dashboardView) {
        this.view = dashboardView;
        iterator = new DashboardInteractor();
        eventBus = EventBus.getDefault();
    }

    @Override
    public void onStart() {
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventLoginThread(LoginEvent event) {
        switch (event.getEventType()) {
            case LoginEvent.SUCCESS_DATA_GET_FROM_DB:
                view.setData(event.getUsuario());
                break;
            case LoginEvent.FAIL_DATA_GET_FROM_DB:
                view.showToast("Error al cargar los datos");
                break;
            case  LoginEvent.UPDATE_SUCCESS:
                view.showToast("Actualizacion Completada");
                view.setData(event.getUsuario());
                break;
            case LoginEvent.UPDATE_ERROR:
                view.showToast("No se ha podido actualizar correctamente");
                break;
            case LoginEvent.LOGOUT_SUCCESS:
                view.showToast("Hasta pronto!");
                view.backToLogin();
                break;
            case LoginEvent.DELETE_ERROR:
                view.showToast("Error, no se ha podido borrar");
                break;
            case LoginEvent.DELETE_SUCCESS:
                view.showToast("Account Deleted");
                view.backToLogin();
        }
    }

    @Override
    public void loadData(String email) {
        iterator.loadData(email);
    }

    @Override
    public void updateName(String id, String newName) {
        iterator.updateData(id,newName);
    }

    @Override
    public void logOut() {
        iterator.logOut();
    }

    @Override
    public void deleteAccount(String id) {
        iterator.deleteData(id);
    }
}
