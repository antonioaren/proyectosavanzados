package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

import org.greenrobot.eventbus.EventBus;

public class DashboardRepository implements  I_DashboardRepository {

    private FirebaseDatabase database;
    private DatabaseReference ref;

    public DashboardRepository() {
        //TODO: Obtener la referencia a Firebase
       database = FirebaseDatabase.getInstance();
       ref = database.getReference("users");
    }

    public void loadData(String email) {
        ref.orderByChild("Email").equalTo(email);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //Usuario users = dataSnapshot.getValue(Usuario.class);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });






    }

    private void postEvents(int type) {
        LoginEvent event = new LoginEvent();
        event.setEventType(type);
        EventBus.getDefault().post(event);

    }


}
