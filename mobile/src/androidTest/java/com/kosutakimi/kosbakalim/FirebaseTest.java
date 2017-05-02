package com.kosutakimi.kosbakalim;

import android.content.Context;
import android.nfc.Tag;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.kosutakimi.kosbakalim.user.User;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class FirebaseTest {
    private static final String TAG ="FirebaseTest" ;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.kosutakimi.kosbakalim", appContext.getPackageName());
        FirebaseBridge newbridge = new FirebaseBridge();
        System.out.println("Can i see that");
        /*
        newbridge.createUserEP("cmpbilge6@gmail.com","deneme123");
        if(newbridge.isSignedIn())
            Log.v(TAG,"Email : "+newbridge.getUserEmail());
        else{
            newbridge.sigInEP("cmpbilge6@gmail.com","deneme123");
            Log.v(TAG,"Email : "+newbridge.getUserEmail());
        }
        */

        //user test
        User user = new User();
        System.out.println("is signed(false): " + user.isSigned());
        //System.out.println("login(false): " + user.login("pillerpilgeler@gmail.com", "123abc")); !!DATABASE IS BROKEN!! (SIGNINEP DONT RETURNING ANYTHING)
        Log.v(TAG,"Email : "+newbridge.getUserEmail());
        System.out.println("sign up(false): " + user.signUp("batuhan16@gmail.com", "crazy boy", "123qwe", "123qqw"));
        System.out.println("sign up(true): " + user.signUp("batuhan15@gmail.com", "crazy boy", "123qwe", "123qwe"));// createUserEP function; excepted : true, returning : false;
       // System.out.println("Original user Create Method : "+ newbridge.createUserEP("batuhan12@gmail.com","123qwe"));
        Log.v(TAG,"Email : "+newbridge.getUserEmail());
        System.out.println("get nick name(true): " + user.getNickname());
        user.setHeight(180);
        System.out.println("get height(180): " + user.getHeight());
        System.out.println("get gender(heli): " + user.getGender());
        System.out.println("get weight(-1): " + user.getWeight());
        user.setGender("male");
        System.out.println("get gender(male): " + user.getGender());

    }
}
