package com.bubbletastic.android.appia.ads.ui;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bubbletastic.android.appia.ads.adds.appiaadsdemo.BR;
import com.bubbletastic.android.appia.ads.adds.appiaadsdemo.R;
import com.bubbletastic.android.appia.ads.model.Advertisement;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by brendanmartens on 1/28/16.
 */
public class AdvertisementListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Advertisement> advertisements;

    public AdvertisementListAdapter(Context context, List<Advertisement> advertisements) {
        this.context = context;
        this.advertisements = advertisements;
    }

    @Override
    public int getCount() {
        if (advertisements == null) {
            return 0;
        }
        return advertisements.size();
    }

    @Override
    public Advertisement getItem(int position) {
        return advertisements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        Advertisement ad = getItem(position);
        ViewDataBinding binding;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.advertisements_item, parent, false);
            binding.setVariable(BR.ad, ad);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            view = convertView;
            binding = (ViewDataBinding) view.getTag();
            binding.setVariable(BR.ad, ad);
        }

        binding.executePendingBindings();

        return view;
    }

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView imageView, String url) {
        if (imageView == null || url == null) {
            return;
        }
        Uri uri = Uri.parse(url);
        Picasso.with(imageView.getContext()).load(uri).into(imageView);
    }
}
