package com.liujc.xselectordemo;

import android.app.Application;

import com.android.xselector.XSelector;


/**
 * 类名称：AppApplication
 * 创建者：Create by liujc
 * 创建时间：Create on 2018/4/17 21:57
 * 描述：TODO
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XSelector.init(this);
    }
}
