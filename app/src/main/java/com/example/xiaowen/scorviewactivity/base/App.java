package com.example.xiaowen.scorviewactivity.base;

import android.app.Application;

/**
 * Created by xiaowen on 2017/5/25.
 */

public class App extends Application {
    private static App cloudReaderApplication;
    public static App getInstance() {
        return cloudReaderApplication;
    }
    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();
        cloudReaderApplication = this;
    }
}
