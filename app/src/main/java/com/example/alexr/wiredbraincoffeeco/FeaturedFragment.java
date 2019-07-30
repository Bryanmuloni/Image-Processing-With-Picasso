package com.example.alexr.wiredbraincoffeeco;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexr.wiredbraincoffeeco.Utilities.FeaturedAdapter;
import com.example.alexr.wiredbraincoffeeco.Utilities.FeaturedItem;

import java.util.ArrayList;

public class FeaturedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_featured, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_featured);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<FeaturedItem> images = new ArrayList<>();
        images.add(new FeaturedItem("ground.jpg", "The Best Coffee", "Its simple but aromatic"));
        images.add(new FeaturedItem("table.jpg", "Stay for a While", "Have a seat lets serve you"));
        images.add(new FeaturedItem("beans.jpg", "Freshly Roasted", "Every morning, Every evening"));
        images.add(new FeaturedItem("granola.jpg", "Healthy Bites", "Start your morning here with " +
                "us"));
        images.add(new FeaturedItem("bag.jpg", "Smells to Go", "Take home some of our beans."));

        mAdapter = new FeaturedAdapter(images);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
