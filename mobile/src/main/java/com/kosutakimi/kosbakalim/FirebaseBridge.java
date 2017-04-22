package com.kosutakimi.kosbakalim;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Created by ze0tron on 22.04.2017.
 */

public class FirebaseBridge {
    private FirebaseAuth mAuth;
    private boolean isPCompleted;
    private boolean multiUseFlag;
    public FirebaseBridge(){
        this.mAuth= FirebaseAuth.getInstance();
        this.multiUseFlag=false;
        this.isPCompleted=true;
    }

    /**
     *
     * @return wheter there is a user currently signed in or not
     */
    public boolean isSignedIn(){
        if(this.mAuth.getCurrentUser()!=null){
            return true;
        }
        return false;
    }

    /**
     * Always run isSignedIn before  calling this function to be sure there is a user in the system.
     * Returns the current user that is signed in to the Firebase system.
     * @return FirebaseUser
     *
     */
    public FirebaseUser getCurrentUser(){
        return this.mAuth.getCurrentUser();
    }

    /**
     * Creates a user with Email and Password
     * @param email
     * @param password
     * @return a boolean expression whether it was successful or not
     */
    public boolean createUserEP(String email, String password){
        this.isPCompleted=false;
        this.mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        isPCompleted=true;
                        if (task.isSuccessful()) {
                            multiUseFlag=true;
                            // Sign in success, update UI with the signed-in user's information

                        }
                        else {
                            // Maybe raise an exception here or from the place it has called;
                               }
                        }
                });
        while(!isPCompleted){

        }
        if(multiUseFlag){
            multiUseFlag=false;
            return true;
            }
        return false;
        }

    /**
     * SignIns a user with email and password
     * @param email
     * @param password
     * @return a boolean expression whether the operation was successful or not
     */
    public boolean sigInEP(String email, String password){
        this.isPCompleted=false;
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            multiUseFlag=true;


                        }
                        else {

                            // Maybe raise an exception here or from the place it has called;
                        }
                    }
                });
        while(!isPCompleted){

        }
        if(multiUseFlag){
            multiUseFlag=false;
            return true;
        }
        return false;
    }

    /**
     *
     * @return the Current Users Email Address.
     */
    public String getUserEmail(){
        return mAuth.getCurrentUser().getEmail();

    }







}
