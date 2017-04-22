package com.kosutakimi.kosbakalim;

import android.content.Context;
import android.nfc.Tag;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

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
        newbridge.createUserEP("cmpbilge6@gmail.com","deneme123");
        if(newbridge.isSignedIn())
            Log.v(TAG,"Email : "+newbridge.getUserEmail());
        else{
            newbridge.sigInEP("cmpbilge6@gmail.com","deneme123");
            Log.v(TAG,"Email : "+newbridge.getUserEmail());


        }
    }
}
