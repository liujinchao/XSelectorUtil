package com.android.xselector.utils;

import android.graphics.drawable.Drawable;

import com.android.xselector.XSelector;

/**
 * @author :liujc
 * @date : 2020/4/30
 * @Description : XSelector的相关帮助类
 */

public class XHelper {
    public static int getColorRes(int color){
        return XSelector.getContext().getResources().getColor(color);
    }
    public static Drawable getDrawableRes(int drawable){
        return XSelector.getContext().getResources().getDrawable(drawable);
    }
}
