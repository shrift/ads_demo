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

public class AdvertisementsActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    Handler uiHandler = new Handler();
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                AppiaAdsApplication application = (AppiaAdsApplication) getApplicationContext();
                final List<Advertisement> advertisements = application.getAdvertisementService().getAdvertisements();
                uiHandler.post(new Runnable() {
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