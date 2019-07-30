package com.example.alexr.wiredbraincoffeeco;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.alexr.wiredbraincoffeeco.Utilities.BannerTransformation;
import com.squareup.picasso.Picasso;

public class CompanyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company, container, false);
        ImageView imageBanner = view.findViewById(R.id.banner);
//        Picasso.get().load(R.drawable.bag).fit().centerCrop().into(imageBanner);
//        Picasso.get().load(R.drawable.bag).transform(new BannerTransformation()).into(imageBanner);
        Picasso.get().load(R.drawable.bag).fit().centerCrop().into(imageBanner);

        ImageView imageOne = view.findViewById(R.id.image_about_one);
        ImageView imageTwo = view.findViewById(R.id.image_about_two);
        ImageView imageThree = view.findViewById(R.id.image_about_three);

        Picasso.get().load(R.drawable.ic_check).resize(96,96).into(imageOne);
        Picasso.get().load(R.drawable.ic_check).into(imageTwo);
        Picasso.get().load(R.drawable.ic_check).into(imageThree);

        Button button = view.findViewById(R.id.uploadButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        return view;
    }

//    public void buttonSubmit(View view) {
//        Intent intent = new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, 1);
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            ImageView imageView = getActivity().findViewById(R.id.image_submission);
            Picasso.get().load(uri).into(imageView);
            imageView.setVisibility(View.VISIBLE);
        }
    }
}
