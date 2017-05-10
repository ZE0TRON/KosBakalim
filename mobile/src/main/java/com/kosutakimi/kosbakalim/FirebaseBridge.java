package com.kosutakimi.kosbakalim;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.GoogleAuthProvider;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by ze0tron on 22.04.2017.
 */

public class FirebaseBridge extends BaseActivity implements
        GoogleApiClient.OnConnectionFailedListener{
    private FirebaseAuth mAuth;
    private boolean isPCompleted;
    private boolean multiUseFlag;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;

    public FirebaseBridge(){
        this.mAuth= FirebaseAuth.getInstance();
        this.multiUseFlag=false;
        this.isPCompleted=true;
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(Integer.toString(R.string.default_web_client_id))
                .requestEmail()
                .build();


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
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            continue;
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
                        isPCompleted=true;
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
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            continue;
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
    private void singInGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        showProgressDialog();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());

                        }

                        // [START_EXCLUDE]
                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
    }



    }

