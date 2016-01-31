package com.bubbletastic.android.appia.ads.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;

import com.bubbletastic.android.appia.ads.AppiaAdsApplication;
import com.bubbletastic.android.appia.ads.adds.appiaadsdemo.R;
import com.bubbletastic.android.appia.ads.model.Advertisement;

import java.util.List;

/**
 * The primary screen UI component for showing the scrollable advertisements.
 */
public class AdvertisementsActivity extends AppCompatActivity {

    //This handler will be created on the main thread, posting a runnable to it will run that code on the main thread.
    private Handler uiHandler = new Handler();

    //Indeterminate progress indicator while downloading ads.
    private ProgressDialog progressDialog;

    //The scrollable content container. It is referred to generically because in portrait it is a listview, in landscape it is a gridview.
    private AdapterView scrollingContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisements_content);
        scrollingContent = (AdapterView) findViewById(R.id.advertisements_content);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.loading_content));
        }
        progressDialog.show();

        //Fetch the advertisements from the internet.
        new Thread(new Runnable() {
            @Override
            public void run() {
                AppiaAdsApplication application = (AppiaAdsApplication) getApplicationContext();
                final List<Advertisement> advertisements = application.getAdvertisementService().getAdvertisements();
                uiHandler.post(new Runnable() {
                    //Once we have our result from the ads service, setup the scrolling content container on the main thread.
                    @Override
                    public void run() {
                        if (scrollingContent != null && progressDialog != null) {
                            //noinspection unchecked
                            scrollingContent.setAdapter(new AdvertisementsAdapter(AdvertisementsActivity.this, advertisements));
                            progressDialog.hide();
                        }
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }
}
