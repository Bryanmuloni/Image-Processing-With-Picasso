package com.example.alexr.wiredbraincoffeeco.Utilities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class GalleryAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data;

    public GalleryAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        int twiceMax = 20;
        int actualMax = 10;
        int degrees = new Random().nextInt(twiceMax) - actualMax;
        Picasso.get().load(UrlHelper.BaseUrl + this.data.get(position)).rotate(degrees).fit().centerCrop()
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .tag("gallery")
                .into((ImageView) convertView);

        return convertView;
    }
}