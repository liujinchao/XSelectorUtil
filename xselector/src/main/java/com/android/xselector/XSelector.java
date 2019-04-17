package com.android.xselector;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;

import com.android.xselector.selector.ColorSelector;
import com.android.xselector.selector.DrawableSelector;
import com.android.xselector.selector.ShapeSelector;
import com.android.xselector.shadow.ShadowHelper;

/**
 * 类名称：XSelector
 * 创建者：Create by liujc
 * 创建时间：Create on 2018/4/15 21:35
 * 描述：selector 工具类
 */
public class XSelector {

    @SuppressLint("StaticFieldLeak")
    private static XSelector selectorUtil;
    @SuppressLint("StaticFieldLeak")
    private static Application context;

    public static XSelector getInstance() {
        initialize();
        if (selectorUtil == null) {
            synchronized (XSelector.class) {
                if (selectorUtil == null) {
                    selectorUtil = new XSelector();
                }
            }
        }
        return selectorUtil;
    }


    /**
     * 必须在全局Application先调用，获取context上下文
     *
     * @param app Application
     */
    public  static void init(Application app) {
        context = app;
    }


    /**
     * 获取全局上下文
     */
    public static Context getContext() {
        initialize();
        return context;
    }

    /**
     * 检测是否调用初始化方法
     */
    private static void initialize() {
        if (context == null) {
            throw new ExceptionInInitializerError("请先在全局Application中调用 XSelector.init() 初始化！");
        }
    }


    /**
     * 设置样式（主要是椭圆和矩形）
     *
     * @return OvalShape
     */
    public static ShapeSelector shapeSelector() {
        return ShapeSelector.getInstance();
    }

    /**
     * Drawable背景选择器
     * @return
     */
    public static DrawableSelector drawableSelector() {
        return DrawableSelector.getInstance();
    }

    /**
     * Color字体颜色选择器
     * @return
     */
    public static ColorSelector colorSelector() {
        return ColorSelector.getInstance();
    }

    /**
     * 阴影工具类
     * @return
     */
    public static ShadowHelper shadowHelper() {
        return ShadowHelper.getInstance();
    }

    /**
     * 背景状态选择器（背景颜色）
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public static DrawableSelector selectorBackground(@ColorRes int pressedColorResId, @ColorRes int normalColorResId) {
        return DrawableSelector.getInstance().selectorBackground(new ColorDrawable(XSelector.getContext().getResources().getColor(pressedColorResId)), new ColorDrawable(XSelector.getContext().getResources().getColor(normalColorResId)));
    }

    /**
     * .
     * 背景状态选择器（背景颜色）
     *
     * @param pressedColor 触摸颜色 例：#ffffff
     * @param normalColor  正常颜色 例：#ffffff
     * @return DrawableSelector
     */
    public static DrawableSelector selectorBackground(String pressedColor, String normalColor) {
        return DrawableSelector.getInstance().selectorBackground(new ColorDrawable(Color.parseColor(pressedColor)), new ColorDrawable(Color.parseColor(normalColor)));
    }

    /**
     * .
     * 背景状态选择器（背景Drawable）
     *
     * @param pressedDrawable 触摸颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @param normalDrawable  正常颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @return DrawableSelector
     */
    public static DrawableSelector selectorBackground(Drawable pressedDrawable, Drawable normalDrawable) {
        return DrawableSelector.getInstance()
                .defaultDrawable(normalDrawable)
                .pressedDrawable(pressedDrawable);
    }


    /**
     * 字体颜色颜色器
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public static ColorSelector selectorColor(@ColorRes int pressedColorResId, @ColorRes int normalColorResId) {
        return ColorSelector.getInstance()
                .selectedColor(pressedColorResId)
                .defaultColor(normalColorResId);
    }


    /**
     * 字体颜色颜色器
     *
     * @param pressedColor 触摸颜色 例：#ffffff
     * @param normalColor  正常颜色 例：#ffffff
     * @return DrawableSelector
     */
    public static ColorSelector selectorColor(String pressedColor, String normalColor) {
        return ColorSelector.getInstance().pressedColor(pressedColor).defaultColor(normalColor);
    }

}
