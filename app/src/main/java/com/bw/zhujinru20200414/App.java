package com.bw.zhujinru20200414;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:app
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
