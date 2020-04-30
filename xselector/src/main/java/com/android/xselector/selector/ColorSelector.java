package com.android.xselector.selector;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.widget.TextView;

import com.android.xselector.interfaces.ISelector;
import com.android.xselector.utils.XHelper;

/**
 * @author :liujc
 * @date : 2020/4/30
 * @Description : 字体颜色状态选择器
 */
public class ColorSelector implements ISelector<ColorStateList, TextView> {

    public enum TextColorType{
        TEXT_COLOR,
        HINT_TEXT_COLOR
    }

    private static ColorSelector mColorSelector;
    private TextColorType textType = TextColorType.TEXT_COLOR;

    private static final int DEFAULT_COLOR_ID = -1;
    //不可点击颜色
    private int disabledColor = DEFAULT_COLOR_ID;
    //获得焦点的颜色
    private int focusedColor = DEFAULT_COLOR_ID;
    //触摸颜色
    private int pressedColor = DEFAULT_COLOR_ID;
    //触摸颜色
    private int selectedColor = DEFAULT_COLOR_ID;
    //正常颜色
    private int normalColor = DEFAULT_COLOR_ID;

    public static ColorSelector getInstance() {
        mColorSelector = new ColorSelector();
        return mColorSelector;
    }

    public ColorSelector defaultColor(@ColorRes int tmpColor) {
        normalColor = XHelper.getColorRes(tmpColor);;
        return this;
    }
    public ColorSelector defaultColor(String tmpColor) {
        normalColor = Color.parseColor(tmpColor);
        return this;
    }

    public ColorSelector disabledColor(@ColorRes int color) {
        disabledColor = XHelper.getColorRes(color);
        return this;
    }

    public ColorSelector disabledColor(String color) {
        disabledColor = Color.parseColor(color);
        return this;
    }

    public ColorSelector pressedColor(@ColorRes int color) {
        pressedColor = XHelper.getColorRes(color);
        return this;
    }

    public ColorSelector pressedColor(String color) {
        pressedColor = Color.parseColor(color);
        return this;
    }

    public ColorSelector selectedColor(@ColorRes int color) {
        selectedColor = XHelper.getColorRes(color);
        return this;
    }
    public ColorSelector selectedColor(String color) {
        selectedColor = Color.parseColor(color);
        return this;
    }

    public ColorSelector focusedColor(@ColorRes int color) {
        focusedColor = XHelper.getColorRes(color);
        return this;
    }
    public ColorSelector focusedColor(String color) {
        focusedColor = Color.parseColor(color);
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

    public ColorSelector textType(TextColorType type) {
        textType = type;
        return this;
    }

    @Override
    public void into(TextView textView) {
        if (isDefaultColorValue(normalColor)){
            throw new IllegalArgumentException("请设置defaultColor属性！");
        }
        if (TextColorType.HINT_TEXT_COLOR == textType){
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
                isDefaultColorValue(disabledColor) ? normalColor : disabledColor,
                isDefaultColorValue(pressedColor) ? normalColor : pressedColor,
                isDefaultColorValue(selectedColor) ? normalColor : selectedColor,
                isDefaultColorValue(focusedColor) ? normalColor: focusedColor,
                normalColor
        };

        return getColorStateList(colors);
    }

    private boolean isDefaultColorValue(int color) {
        return color == DEFAULT_COLOR_ID;
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
