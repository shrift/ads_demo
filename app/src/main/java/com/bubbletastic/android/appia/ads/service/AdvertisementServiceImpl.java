package com.bubbletastic.android.appia.ads.service;

import com.bubbletastic.android.appia.ads.model.Advertisement;
import com.bubbletastic.android.appia.ads.model.wrapper.AdvertisementResponseWrapper;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by brendanmartens on 1/28/16.
 */

public class AdvertisementServiceImpl implements AdvertisementService {

    private static final String APPIA_SERVICE_URL =
            "http://ads.appia.com/getAds?id=236&password=OVUJ1DJN&siteId=4288&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=100&lname=martens";

    private final OkHttpClient okHttpClient;

    public AdvertisementServiceImpl(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public List<Advertisement> getAdvertisements() {

        try {
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(APPIA_SERVICE_URL).build();
            Response response = null;
            response = okHttpClient.newCall(request).execute();
            Serializer parser = new Persister();
            AdvertisementResponseWrapper wrapper = parser.read(AdvertisementResponseWrapper.class, response.body().byteStream());
            if (wrapper != null) {
                return wrapper.getAdvertisements();
            }
        } catch (Exception e) {
            //parser.read does actually throw "Exception".
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
