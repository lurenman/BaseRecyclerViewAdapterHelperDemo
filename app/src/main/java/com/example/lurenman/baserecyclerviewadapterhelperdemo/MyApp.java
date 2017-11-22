package com.example.lurenman.baserecyclerviewadapterhelperdemo;

import android.app.Application;
import android.content.Context;

/**
 * @author: baiyang.
 * Created on 2017/11/21.
 */

public class MyApp extends Application {
    public static Context AppContext;
    @Override
    public void onCreate() {
        super.onCreate();
        AppContext=this;
    }
}
