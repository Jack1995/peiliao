package com.wenmingkeji.peiliao.okhttputils;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

/**
 * Created by luoliwen on 16/5/13.
 */
public class CropSquareTrans implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(),source.getHeight());
        int x = (source.getWidth()-size)/2;
        int y = (source.getHeight()-size)/2;
        Bitmap bitmap = Bitmap.createBitmap(source,x,y,size,size);
        if (bitmap!=source){
            source.recycle();
        }
        return bitmap;
    }

    @Override
    public String key() {
        return "square()";
    }
}
