package com.baseandroid.util;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Created by FreeMason on 2016/5/25.
 */
public class ImagesOptionUtil {
    private static DisplayImageOptions defaultOptions;




    public static DisplayImageOptions getDefaultOptions() {
        if (defaultOptions != null)
            return defaultOptions;
        defaultOptions = new DisplayImageOptions.Builder()
//			.showStubImage(R.drawable.placeholder)
//			.showImageForEmptyUri(R.drawable.ic_empty)
//			.showImageOnFail(R.drawable.ic_error)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        return defaultOptions;
    }

}
