package com.bubbletastic.android.appia.ads.model.wrapper;

import com.bubbletastic.android.appia.ads.model.Advertisement;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * This class wraps a list of Advertisements to make parsing the xml responses easier.
 * It is set to strict = false so that other elements on the root node will be ignored (we don't care about them at this time).
 * Created by brendanmartens on 1/28/16.
 */
@Root(name = "ads", strict = false)
public class AdvertisementResponseWrapper {

    @ElementList(inline = true)
    List<Advertisement> advertisements = new ArrayList<>();

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String toString() {
        return "AdvertisementResponseWrapper{" +
                "advertisements=" + advertisements +
                '}';
    }
}
