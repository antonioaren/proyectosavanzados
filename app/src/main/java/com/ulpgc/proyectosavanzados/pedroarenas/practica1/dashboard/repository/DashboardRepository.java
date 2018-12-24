package com.ulpgc.proyectosavanzados.pedroarenas.practica1.dashboard.repository;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.indentity.Usuario;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

import org.greenrobot.eventbus.EventBus;

public class DashboardRepository implements  I_DashboardRepository {

    private FirebaseUser user;
    private DatabaseReference userUpdate;

    public DashboardRepository() {
        //TODO: Obtener la referencia a Firebase
       user = FirebaseAuth.getInstance().getCurrentUser();
       userUpdate = FirebaseDatabase.getInstance().getReference();
    }

    public void loadData(final String email) {
        DatabaseReference usuario = FirebaseDatabase.getInstance().getReference();
        usuario.child("users").orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Usuario usuario = new Usuario();
                    usuario.setName(data.child("name").getValue().toString());
                    usuario.setID(data.child("id").getValue().toString());
                    usuario.setEmail(data.child("email").getValue().toString());
                    postEvents(LoginEvent.SUCCESS_DATA_GET_FROM_DB, usuario);
                }
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                postEvents(LoginEvent.FAIL_DATA_GET_FROM_DB);
            }
        });

    }

    public void updateData(String id, String name) {
        final DatabaseReference usuario = FirebaseDatabase.getInstance().getReference();
        usuario.child("users").orderByChild(id).equalTo(id);
        usuario.child("users").child(id).child("name").setValue(name);
        usuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    postEvents(LoginEvent.UPDATE_SUCCESS);
                }

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                postEvents(LoginEvent.UPDATE_ERROR);
            }
        });
    }

    public void deleteData (String id) {
        DatabaseReference usuario = FirebaseDatabase.getInstance().getReference().child("users").child(id);
        usuario.removeValue();
        this.user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    //TODO: Borrado Correcto
                    postEvents(LoginEvent.DELETE_SUCCESS);
                } else {
                    //TODO: Error al Borrar
                    postEvents(LoginEvent.DELETE_ERROR);
                }
            }
        });

    }

    public void logOut () {
        FirebaseAuth.getInstance().signOut();
        //TODO: Notificar que se ha deslogueado
        postEvents(LoginEvent.LOGOUT_SUCCESS);
    }

    private void postEvents(int type, Usuario usuario) {
        LoginEvent event = new LoginEvent();
        event.setEventType(type);
        event.setUsuario(usuario);
        EventBus.getDefault().post(event);
    }

    private void postEvents(int type) {
        LoginEvent event = new LoginEvent();
        event.setEventType(type);
        EventBus.getDefault().post(event);
    }


}
