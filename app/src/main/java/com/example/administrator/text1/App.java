package com.example.administrator.text1;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/12/6.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
