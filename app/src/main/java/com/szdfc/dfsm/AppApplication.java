package com.szdfc.dfsm;

import com.baseandroid.BaseApplication;
import com.facebook.stetho.Stetho;

/**
 * Created by FreeMason on 2016/7/5.
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
