package com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.repository;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ulpgc.proyectosavanzados.pedroarenas.practica1.login.events.LoginEvent;

import org.greenrobot.eventbus.EventBus;


public class LoginRepository implements I_LoginRepository {

    private FirebaseAuth mAuth;


    public LoginRepository() {

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void singUp(String email, String password) {

    }

    @Override
    public void singIn(String email, String password) {

        try {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //If login is ok
                                Log.d("AUTENTICATION", "signInWithEmail:success");
                                postEvents(LoginEvent.SUCCESS_LOG_IN);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("AUTENTICATION", "signInWithEmail:failure", task.getException());
                                postEvents(LoginEvent.ERROR_LOG_IN);
                            }

                        }
                    });

        } catch (Exception e) {
            postEvents(LoginEvent.ERROR_LOG_IN);
        }
    }

    @Override
    public void forgotPass(String email) {

    }

    private void postEvents(int type) {
        LoginEvent event = new LoginEvent();
        event.setEventType(type);
        EventBus.getDefault().post(event);

    }

    @Override
    public void saveOnDB(String name, String mail, String pass) {

    }
}
