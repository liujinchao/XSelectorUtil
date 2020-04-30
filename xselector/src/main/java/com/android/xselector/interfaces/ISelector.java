package com.android.xselector.interfaces;

import android.view.View;

/**
 * @author :liujc
 * @date : 2020/4/30
 * @Description : TODO
 */
public interface ISelector<T,V extends View> {

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
