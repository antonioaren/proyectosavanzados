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
        eventBus.register(this); //ESTE ES EL ERROR
    }

    @Override
    public void onStop() {
        //viewLogin = null;
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventLoginThread(LoginEvent event) {
        switch (event.getEventType()) {
            case LoginEvent.SUCCESS_DATA_GET_FROM_DB:
                //viewLogin.giveAccess();
                break;
            case LoginEvent.FAIL_DATA_GET_FROM_DB:
                //view.mostrarResetearContrasenaEnviada();
                break;
        }
    }

    @Override
    public void loadData(String email) {
        iterator.loadData(email);
    }
}
