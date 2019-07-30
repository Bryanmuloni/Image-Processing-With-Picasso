package com.example.alexr.wiredbraincoffeeco.Utilities;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

/**
 * Created by Sirikye Brian on 7/29/2019.
 * bryanmuloni@gmail.com
 */
public class BannerTransformation implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        int originalHeight = source.getHeight();
        int totalMargin = originalHeight / 2;
        int croppedImageHeight = originalHeight / 2;

        Bitmap croppedImage = Bitmap.createBitmap(source, 0, totalMargin / 2, source.getWidth(),
                croppedImageHeight);
        if (croppedImage != source) {
            source.recycle();
        }
        return croppedImage;
    }

    @Override
    public String key() {
        return "Banner Transformation";
    }
}
