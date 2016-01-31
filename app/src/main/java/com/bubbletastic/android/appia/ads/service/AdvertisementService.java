package com.bubbletastic.android.appia.ads.service;

import com.bubbletastic.android.appia.ads.model.Advertisement;

import java.util.List;

/**
 * Created by brendanmartens on 1/28/16.
 */
public interface AdvertisementService {

    /**
     * Gets a list of advertisements from Appia's service.
     * The list returned is filtered by the advertisements minOSVersion.
     * @return List of Advertisement.
     */
    List<Advertisement> getAdvertisements();
}
