package com.demo;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smaato.sdk.core.SmaatoSdk;

public class SmaatoApplication extends Application {
    private String publisherId = "1100042525";

    @Override
    public void onCreate() {
        super.onCreate();
        SmaatoSdk.init(this, publisherId);
        setGDPRConsent();
    }

    private void  setGDPRConsent()
    {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putString("IABConsent_SubjectToGDPR", "1");
        editor.putString("IABConsent_ParsedVendorConsents","1");
        editor.putString("IABConsent_ParsedPurposeConsents","1111100000");
        editor.putString("IABConsent_ConsentString","BOvyXKmOvyXKmAGABBENC_-AAAAuh7_______9______9uz_Ov_v_f__33e8__9v_l_7_-___u_-33d4-_1vf99yfm1-7ftr3tp_87ues2_Xur__79__3z3_9pxP78k89r7337Mw_v-_v-b7JCON_IwAAA");
        editor.putBoolean("IABConsent_CMPPresent",true);
        editor.apply();
    }
}
