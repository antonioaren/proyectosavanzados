package com.ulpgc.proyectosavanzados.pedroarenas.practica1.registration.repository;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.indentity.Usuario;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

import org.greenrobot.eventbus.EventBus;

public class RegisterRepository implements I_RegisterRepository {
    private FirebaseAuth mAuth;

    public RegisterRepository() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String pasword) {

    }

    @Override
    public void forgotPass(String email) {

    }


    public void signUp(final String name, final String mail, String password) {
        try {
            mAuth.createUserWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                // Sign in success, update UI with the signed-in user's information

                                FirebaseDatabase database = FirebaseDatabase.getInstance();

                                DatabaseReference ref = database.getReference().child("users");
                                String key = ref.push().getKey();
                                Usuario user = new Usuario ();
                                user.setID(key);
                                user.setName(name);
                                user.setEmail(mail);
                                ref.child(key).setValue(user);


                                postEvents(LoginEvent.SUCCESS_ALTA);
                            } else {
                                String console = "Error al crear";
                                // If sign in fails, display a message to the user.
                                postEvents(LoginEvent.ERROR_ALTA);
                            }
                        }
                    });
        } catch (Exception e) {
            String console = "Error";
            postEvents(LoginEvent.ERROR_ALTA);
        }

    }

    private void postEvents(int type) {
        LoginEvent event = new LoginEvent();
        event.setEventType(type);
        EventBus.getDefault().post(event);

    }
}
