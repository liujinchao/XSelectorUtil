package com.android.xselector.utils;

import android.graphics.drawable.Drawable;

import com.android.xselector.XSelector;

/**
 * 类名称：XHelper
 * 创建者：Create by liujc
 * 创建时间：Create on 2018/4/17 21:48
 * 描述：XSelector的相关帮助类
 */
public class XHelper {
    public static int getColorRes(int color){
        return XSelector.getContext().getResources().getColor(color);
    }
    public static Drawable getDrawableRes(int drawable){
        return XSelector.getContext().getResources().getDrawable(drawable);
    }
}
