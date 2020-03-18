package com.demo.smaatotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.idling.CountingIdlingResource;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.core.AdContentRating;
import com.smaato.sdk.core.Config;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.log.LogLevel;

public class MainActivity extends AppCompatActivity {

    private final String adspaceId = "130626424";
    private BannerView bannerView;
    private CountingIdlingResource mIdlingRes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bannerView = (BannerView) findViewById(R.id.bannerView);
        Button showAddButton = findViewById(R.id.show_ad_btn);
        showAddButton.setOnClickListener(view -> {bannerView.loadAd(adspaceId, BannerAdSize.XX_LARGE_320x50);
        if(mIdlingRes != null) {
          mIdlingRes.increment();
        }
        });
        bannerView.setEventListener(new BannerView.EventListener() {
            @Override
            public void onAdLoaded(BannerView bannerView) {
                if(mIdlingRes != null) {
                    mIdlingRes.decrement();
                }
            }
            @Override
            public void onAdFailedToLoad( BannerView bannerView, BannerError bannerError) {
                Toast.makeText(MainActivity.this, "Failed: "+bannerError.toString(), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onAdImpression(BannerView bannerView) {}
            @Override
            public void onAdClicked(BannerView bannerView) {
                MainActivity.this.onAdClicked();
            }
            @Override
            public void onAdTTLExpired(BannerView bannerView) {}
        });
    }

    public void onAdClicked() {
        // TODO:
    }
    public CountingIdlingResource getIdlingResourceInTest() {
        if(mIdlingRes == null) {
            mIdlingRes = new CountingIdlingResource("MainActivity");
        }
        return mIdlingRes;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerView.destroy();
    }
}
