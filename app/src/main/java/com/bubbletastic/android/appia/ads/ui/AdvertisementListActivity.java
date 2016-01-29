package com.bubbletastic.android.appia.ads.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bubbletastic.android.appia.ads.AppiaAdsApplication;
import com.bubbletastic.android.appia.ads.adds.appiaadsdemo.R;
import com.bubbletastic.android.appia.ads.model.Advertisement;

import java.util.List;

public class AdvertisementListActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    Handler uiHandler = new Handler();
    private ListView adListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisements_list);
        adListView = (ListView) findViewById(R.id.activity_advertisements_list);
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
                        adListView.setAdapter(new AdvertisementListAdapter(AdvertisementListActivity.this, advertisements));
                        progressDialog.hide();
                    }
                });
            }
        }).start();

    }
}
