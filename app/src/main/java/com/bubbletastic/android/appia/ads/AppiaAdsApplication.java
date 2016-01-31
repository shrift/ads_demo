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

        //Create the advertisement service for the app to use.
        OkHttpClient okHttpClient = new OkHttpClient();
        advertisementService = new AdvertisementServiceImpl(okHttpClient);

    }

    /**
     * This getter for the advertisement service is on the application context for simple service access.
     * The scope of this project is small so dependency injection or other forms of dependency management are overkill.
     * @return AdvertisementService
     */
    public AdvertisementService getAdvertisementService() {
        return advertisementService;
    }
}
