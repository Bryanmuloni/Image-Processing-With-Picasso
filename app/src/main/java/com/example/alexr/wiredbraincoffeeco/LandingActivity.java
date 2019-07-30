package com.example.alexr.wiredbraincoffeeco;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alexr.wiredbraincoffeeco.Utilities.UrlHelper;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class LandingActivity extends AppCompatActivity {
    private Target mTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        final ImageView landingLogo = findViewById(R.id.image_logo);

        Picasso.get().setLoggingEnabled(true);
        Picasso.get().setIndicatorsEnabled(true);

        mTarget = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                landingLogo.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Toast.makeText(LandingActivity.this, "Your internet connection may need more Espresso", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        Picasso.get().load("http://www.alexwolfps.com/images/logo.png").into(mTarget);

        String[] urls = new String[]{
                "ground.jpg",
                "table.jpg",
                "beans.jpg",
                "granola.jpg",
                "bag.jpg"
        };

        for (String url : urls){
            Picasso.get().load(UrlHelper.BaseUrl + url).fetch();
        }
    }

    public void getStarted(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
