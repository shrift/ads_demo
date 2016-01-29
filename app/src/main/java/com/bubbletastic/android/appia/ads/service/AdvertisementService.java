package com.bubbletastic.android.appia.ads.service;

import java.util.List;

import com.bubbletastic.android.appia.ads.model.Advertisement;

/**
 * Created by brendanmartens on 1/28/16.
 */
public interface AdvertisementService {

    /**
     * @return List of Advertisement.
     */
    List<Advertisement> getAdvertisements();
}
