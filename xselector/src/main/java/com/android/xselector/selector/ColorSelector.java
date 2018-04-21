package com.android.xselector.selector;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.widget.TextView;

import com.android.xselector.interfaces.ISelectorUtil;
import com.android.xselector.utils.XHelper;


/**
 * 类名称：ColorSelector
 * 创建者：Create by liujc
 * 创建时间：Create on 2018/4/14 16:37
 * 描述：字体颜色状态选择器
 */
public class ColorSelector implements ISelectorUtil<ColorStateList, TextView> {
    private static ColorSelector mColorSelector;
    public static int TEXT_COLOR = 1;
    public static int HINT_TEXT_COLOR = 2;
    private int textType = TEXT_COLOR;

    //不可点击颜色
    private int disabledColor;
    //获得焦点的颜色
    private int focusedColor;
    //触摸颜色
    private int pressedColor;
    //触摸颜色
    private int selectedColor;
    //正常颜色
    private int normalColor;

    private boolean hasSetDisabledColor = false;
    private boolean hasSetPressedColor = false;
    private boolean hasSetSelectedColor = false;
    private boolean hasSetFocusedColor = false;

    public static ColorSelector getInstance() {
        mColorSelector = new ColorSelector();
        return mColorSelector;
    }

    public ColorSelector defaultColor(@ColorRes int tmpColor) {
        int color = XHelper.getColorRes(tmpColor);
        normalColor = color;
        if (!hasSetDisabledColor)
            disabledColor = color;
        if (!hasSetPressedColor)
            pressedColor = color;
        if (!hasSetSelectedColor)
            selectedColor = color;
        if (!hasSetFocusedColor)
            focusedColor = color;
        return this;
    }
    public ColorSelector defaultColor(String tmpColor) {
        int color = Color.parseColor(tmpColor);
        normalColor = color;
        if (!hasSetDisabledColor)
            disabledColor = color;
        if (!hasSetPressedColor)
            pressedColor = color;
        if (!hasSetSelectedColor)
            selectedColor = color;
        if (!hasSetFocusedColor)
            focusedColor = color;
        return this;
    }

    public ColorSelector disabledColor(@ColorRes int color) {
        disabledColor = XHelper.getColorRes(color);
        hasSetDisabledColor = true;
        return this;
    }

    public ColorSelector disabledColor(String color) {
        disabledColor = Color.parseColor(color);
        hasSetDisabledColor = true;
        return this;
    }

    public ColorSelector pressedColor(@ColorRes int color) {
        pressedColor = XHelper.getColorRes(color);
        hasSetPressedColor = true;
        return this;
    }

    public ColorSelector pressedColor(String color) {
        pressedColor = Color.parseColor(color);
        hasSetPressedColor = true;
        return this;
    }

    public ColorSelector selectedColor(@ColorRes int color) {
        selectedColor = XHelper.getColorRes(color);
        hasSetSelectedColor = true;
        return this;
    }
    public ColorSelector selectedColor(String color) {
        selectedColor = Color.parseColor(color);
        hasSetSelectedColor = true;
        return this;
    }

    public ColorSelector focusedColor(@ColorRes int color) {
        focusedColor = XHelper.getColorRes(color);
        hasSetFocusedColor = true;
        return this;
    }
    public ColorSelector focusedColor(String color) {
        focusedColor = Color.parseColor(color);
        hasSetFocusedColor = true;
        return this;
    }

    /**
     * 背景状态选择器（背景颜色）
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public ColorSelector selectorColor(int pressedColorResId, int normalColorResId) {
        this.pressedColor = pressedColorResId;
        this.normalColor = normalColorResId;
        return this;
    }

    public ColorSelector textType(int type) {
        textType = type;
        return this;
    }

    @Override
    public void into(TextView textView) {
        if (HINT_TEXT_COLOR == textType){
            textView.setHintTextColor(create());
        }else {
            textView.setTextColor(create());
        }
    }

    @Override
    public ColorStateList build() {
        return create();
    }

    /**
     * 创建触摸颜色变化
     *
     * @return ColorStateList
     */
    public ColorStateList create() {
        int[] colors = new int[]{
                hasSetDisabledColor ? disabledColor : normalColor,
                hasSetPressedColor ? pressedColor : normalColor,
                hasSetSelectedColor ? selectedColor : normalColor,
                hasSetFocusedColor ? focusedColor : normalColor,
                normalColor
        };

        return getColorStateList(colors);
    }

    public ColorStateList getColorStateList(int[] colors) {
        int[][] states = new int[5][];
        states[0] = new int[]{-android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_pressed};
        states[2] = new int[]{android.R.attr.state_selected};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{};
        return new ColorStateList(states,colors);
    }

}
