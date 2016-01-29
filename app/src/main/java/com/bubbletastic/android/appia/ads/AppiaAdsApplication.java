package com.bubbletastic.android.appia.ads;

import android.app.Application;

import com.bubbletastic.android.appia.ads.service.AdvertisementService;
import com.bubbletastic.android.appia.ads.service.AdvertisementServiceImpl;

import okhttp3.OkHttpClient;

/**
 * Created by brendanmartens on 1/28/16.
 */
public class AppiaAdsApplication extends Application {

    private AdvertisementService advertisementService;

    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient okHttpClient = new OkHttpClient();
        advertisementService = new AdvertisementServiceImpl(okHttpClient);

    }

    public AdvertisementService getAdvertisementService() {
        return advertisementService;
    }
}
