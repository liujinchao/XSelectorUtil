package com.android.xselector.interfaces;

import android.view.View;

/**
 * 类名称：ISelectorUtil
 * 创建者：Create by liujc
 * 创建时间：Create on 2018/4/14 16:36
 * 描述：TODO
 */
public interface ISelectorUtil<T,V extends View> {

    /**
     * 目标view
     * @param v 需要设置样式的view
     */
    void into(V v);

    /**
     * 返回Drawable样式
     * @return T
     */
    T build();
}
