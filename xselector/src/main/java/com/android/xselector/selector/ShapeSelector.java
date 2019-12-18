package com.android.xselector.selector;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.Dimension;
import android.support.annotation.IntDef;
import android.support.annotation.StringDef;
import android.view.View;

import com.android.xselector.XSelector;
import com.android.xselector.interfaces.ISelectorUtil;
import com.android.xselector.utils.XHelper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 类名称：ShapeSelector
 * 创建者：Create by liujc
 * 创建时间：Create on 2018/4/14 16:41
 * 描述：选择器形状
 */
public class ShapeSelector implements ISelectorUtil<Drawable, View> {
    static ShapeSelector mDevShape;

    //实线宽度 默认1px
    private int lineWidth = 1;
    /*虚线参数*/
    //虚线宽度 默认1px
    private int dashLineWidth = 1;
    //虚线颜色
    private int dashLineColor = 1;
    //虚线宽度
    private float dashWidth = 1;
    //虚线间隙宽度
    private float dashGap = 1;

    /*渐变参数*/
    //渐变颜色数组
    private int[] gradientColors;
    //辐射渐变半径
    private float radialRadius;
    //渐变类型  默认线性
    private int gradientType = GradientDrawable.LINEAR_GRADIENT;
    //渐变方向 默认从上到下
    private @GradientOrientation
    String gradientOrientation = TOP_BOTTOM;

    /*线性渐变方向定义*/
    //上到下渐变
    public static final String TOP_BOTTOM = "TOP_BOTTOM";
    //右上到左下渐变
    public static final String TR_BL = "TR_BL";
    //右到左渐变
    public static final String RIGHT_LEFT = "RIGHT_LEFT";
    //右下到左上渐变
    public static final String BR_TL = "BR_TL";
    //下到上渐变
    public static final String BOTTOM_TOP = "BOTTOM_TOP";
    //左下到右上渐变
    public static final String BL_TR = "BL_TR";
    //左到右渐变
    public static final String LEFT_RIGHT = "LEFT_RIGHT";
    //左上到右下渐变
    public static final String TL_BR = "TL_BR";


    /*设置样式标志位*/
    //是否设置背景
    private boolean isBackgroundColor;
    //是否边框实线样式
    private boolean isLine;
    //是否边框虚线样式
    private boolean isDashLine;
    //是否渐变
    private boolean isGradient;

    /*设置圆角*/
    //是否圆角
    private boolean isRadius;
    //右上圆角弧度
    private float topRightRadius = 0;
    //左上圆角弧度
    private float topLeftRadius = 0;
    //右下圆角弧度
    private float bottomRightRadius = 0;
    //左下圆角弧度
    private float bottomLeftRadius = 0;

    @IntDef({GradientDrawable.RECTANGLE, GradientDrawable.OVAL,
            GradientDrawable.LINE, GradientDrawable.RING})
    private @interface Shape {}

    @StringDef({TOP_BOTTOM, TR_BL, RIGHT_LEFT, BR_TL, BOTTOM_TOP, BL_TR, LEFT_RIGHT, TL_BR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GradientOrientation {
    }

    private int mShape;               //the shape of background
    private int mDefaultBgColor;      //default background color
    private int mDisabledBgColor;     //state_enabled = false
    private int mPressedBgColor;      //state_pressed = true
    private int mSelectedBgColor;     //state_selected = true
    private int mFocusedBgColor;      //state_focused = true
    private int mStrokeWidth;         //stroke width in pixel
    private int mDefaultStrokeColor;  //default stroke color
    private int mDisabledStrokeColor; //state_enabled = false
    private int mPressedStrokeColor;  //state_pressed = true
    private int mSelectedStrokeColor; //state_selected = true
    private int mFocusedStrokeColor;  //state_focused = true
    private int mCornerRadius;        //corner radius

    private boolean hasSetDisabledBgColor = false;
    private boolean hasSetPressedBgColor = false;
    private boolean hasSetSelectedBgColor = false;
    private boolean hasSetFocusedBgColor = false;

    private boolean hasSetDisabledStrokeColor = false;
    private boolean hasSetPressedStrokeColor = false;
    private boolean hasSetSelectedStrokeColor = false;
    private boolean hasSetFocusedStrokeColor = false;

    private ShapeSelector() {
        mShape = GradientDrawable.RECTANGLE;
        mStrokeWidth = 0;
        mCornerRadius = 0;
    }


    public static ShapeSelector getInstance() {
        mDevShape = new ShapeSelector();
        return mDevShape;
    }

    /**
     *  设置背景类型
     * @param shape
     * @return
     */
    public ShapeSelector setShape(@Shape int shape) {
        mShape = shape;
        return this;
    }

    /**
     *  设置默认背景颜色颜色
     * @param tmpColor  R.color.red
     * @return
     * 以下各方法类似
     */
    public ShapeSelector defaultBgColor(@ColorRes int tmpColor) {
        int color = XHelper.getColorRes(tmpColor);
        mDefaultBgColor = color;
        isBackgroundColor = true;
        if (!hasSetDisabledBgColor)
            mDisabledBgColor = color;
        if (!hasSetPressedBgColor)
            mPressedBgColor = color;
        if (!hasSetSelectedBgColor)
            mSelectedBgColor = color;
        if (!hasSetFocusedBgColor)
            mFocusedBgColor = color;
        return this;
    }

    /**
     * 设置默认背景颜色颜色
     * @param tmpColor  #FFFF0000
     * @return
     * 以下各方法类似
     */
    public ShapeSelector defaultBgColor(String tmpColor) {
        int color = Color.parseColor(tmpColor);
        mDefaultBgColor = color;
        isBackgroundColor = true;
        if (!hasSetDisabledBgColor)
            mDisabledBgColor = color;
        if (!hasSetPressedBgColor)
            mPressedBgColor = color;
        if (!hasSetSelectedBgColor)
            mSelectedBgColor = color;
        if (!hasSetFocusedBgColor)
            mFocusedBgColor = color;
        return this;
    }


    /**
     *  设置不可点击背景色
     * @param color
     * @return
     */
    public ShapeSelector disabledBgColor(@ColorRes int color) {
        mDisabledBgColor = XHelper.getColorRes(color);
        hasSetDisabledBgColor = true;
        isBackgroundColor = true;
        return this;
    }
    public ShapeSelector disabledBgColor(String color) {
        mDisabledBgColor = Color.parseColor(color);
        hasSetDisabledBgColor = true;
        isBackgroundColor = true;
        return this;
    }

    public ShapeSelector pressedBgColor(@ColorRes int color) {
        mPressedBgColor = XHelper.getColorRes(color);
        hasSetPressedBgColor = true;
        isBackgroundColor = true;
        return this;
    }
    public ShapeSelector pressedBgColor(String color) {
        mPressedBgColor = Color.parseColor(color);
        hasSetPressedBgColor = true;
        isBackgroundColor = true;
        return this;
    }

    public ShapeSelector selectedBgColor(@ColorRes int color) {
        mSelectedBgColor = XHelper.getColorRes(color);
        hasSetSelectedBgColor = true;
        isBackgroundColor = true;
        return this;
    }
    public ShapeSelector selectedBgColor(String color) {
        mSelectedBgColor = Color.parseColor(color);
        hasSetSelectedBgColor = true;
        isBackgroundColor = true;
        return this;
    }

    public ShapeSelector focusedBgColor(@ColorRes int color) {
        mFocusedBgColor = XHelper.getColorRes(color);
        isBackgroundColor = true;
        hasSetPressedBgColor = true;
        return this;
    }

    public ShapeSelector focusedBgColor(String color) {
        mFocusedBgColor = Color.parseColor(color);
        isBackgroundColor = true;
        hasSetPressedBgColor = true;
        return this;
    }

    public ShapeSelector strokeWidth(@Dimension int width) {
        mStrokeWidth = width;
        return this;
    }

    public ShapeSelector defaultStrokeColor(@ColorRes int tmpColor) {
        int color = XHelper.getColorRes(tmpColor);
        mDefaultStrokeColor = color;
        isLine = true;
        if (!hasSetDisabledStrokeColor)
            mDisabledStrokeColor = color;
        if (!hasSetPressedStrokeColor)
            mPressedStrokeColor = color;
        if (!hasSetSelectedStrokeColor)
            mSelectedStrokeColor = color;
        if (!hasSetFocusedStrokeColor)
            mFocusedStrokeColor = color;
        return this;
    }

    public ShapeSelector defaultStrokeColor(String tmpColor) {
        int color = Color.parseColor(tmpColor);
        mDefaultStrokeColor = color;
        isLine = true;
        if (!hasSetDisabledStrokeColor)
            mDisabledStrokeColor = color;
        if (!hasSetPressedStrokeColor)
            mPressedStrokeColor = color;
        if (!hasSetSelectedStrokeColor)
            mSelectedStrokeColor = color;
        if (!hasSetFocusedStrokeColor)
            mFocusedStrokeColor = color;
        return this;
    }

    public ShapeSelector disabledStrokeColor(@ColorRes int color) {
        mDisabledStrokeColor = XHelper.getColorRes(color);
        hasSetDisabledStrokeColor = true;
        isLine = true;
        return this;
    }
    public ShapeSelector disabledStrokeColor(String color) {
        mDisabledStrokeColor = Color.parseColor(color);
        hasSetDisabledStrokeColor = true;
        isLine = true;
        return this;
    }

    public ShapeSelector pressedStrokeColor(@ColorRes int color) {
        mPressedStrokeColor = XHelper.getColorRes(color);
        hasSetPressedStrokeColor = true;
        isLine = true;
        return this;
    }
    public ShapeSelector pressedStrokeColor(String color) {
        mPressedStrokeColor = Color.parseColor(color);
        hasSetPressedStrokeColor = true;
        isLine = true;
        return this;
    }

    public ShapeSelector selectedStrokeColor(@ColorRes int color) {
        mSelectedStrokeColor = XHelper.getColorRes(color);
        hasSetSelectedStrokeColor = true;
        isLine = true;
        return this;
    }
    public ShapeSelector selectedStrokeColor(String color) {
        mSelectedStrokeColor = Color.parseColor(color);
        hasSetSelectedStrokeColor = true;
        isLine = true;
        return this;
    }

    public ShapeSelector focusedStrokeColor(@ColorRes int color) {
        mFocusedStrokeColor = XHelper.getColorRes(color);
        hasSetFocusedStrokeColor = true;
        isLine = true;
        return this;
    }
    public ShapeSelector focusedStrokeColor(String color) {
        mFocusedStrokeColor = Color.parseColor(color);
        hasSetFocusedStrokeColor = true;
        isLine = true;
        return this;
    }

    /**
     * 边框虚线样式
     *
     * @param dashLineColorResId 边框线颜色 例：R.color.colorPrimary
     * @param dashLineWidth      边框虚线宽度 px
     * @param dashWidth          虚线宽度 px
     * @param dashGap            间隙宽度 px
     * @return BaseShape
     */
    public ShapeSelector dashLine(int dashLineWidth, @ColorRes int dashLineColorResId, float dashWidth, float dashGap) {
        this.isDashLine = true;
        this.dashLineWidth = dashLineWidth;
        this.dashWidth = dashWidth;
        this.dashGap = dashGap;
        this.dashLineColor = XSelector.getContext().getResources().getColor(dashLineColorResId);
        return this;
    }


    /**
     * 边框虚线样式
     *
     * @param dashLineColor 边框线颜色 例：#ffffff
     * @param dashLineWidth 边框虚线宽度 px
     * @param dashWidth     虚线宽度 px
     * @param dashGap       间隙宽度 px
     * @return BaseShape
     */
    public ShapeSelector dashLine(int dashLineWidth, String dashLineColor, float dashWidth, float dashGap) {
        this.isDashLine = true;
        this.dashLineWidth = dashLineWidth;
        this.dashWidth = dashWidth;
        this.dashGap = dashGap;
        this.dashLineColor = Color.parseColor(dashLineColor);
        return this;
    }

    /**
     * 渐变样式
     * 默认 线性渐变 GradientDrawable.LINEAR_GRADIENT
     * 默认方向 从上到下渐变 GradientDrawable.Orientation.TOP_BOTTOM
     *
     * @param startColor 渐变开始端颜色 例：R.color.colorPrimary
     * @param endColor   渐变结束端颜色 例：R.color.colorPrimary
     * @return BaseShape
     */
    public ShapeSelector gradient(@ColorRes int startColor, @ColorRes int endColor) {
        this.isGradient = true;
        this.gradientColors = new int[2];
        this.gradientColors[0] = XSelector.getContext().getResources().getColor(startColor);
        this.gradientColors[1] = XSelector.getContext().getResources().getColor(endColor);
        this.gradientType = GradientDrawable.LINEAR_GRADIENT;
        this.gradientOrientation = TOP_BOTTOM;
        return this;
    }

    /**
     * 渐变样式
     * 默认 线性渐变 GradientDrawable.LINEAR_GRADIENT
     * 默认方向 从上到下渐变 GradientDrawable.Orientation.TOP_BOTTOM
     *
     * @param startColor 渐变开始端颜色 例：#ffffff
     * @param endColor   渐变结束端颜色 例：#ffffff
     * @return BaseShape
     */
    public ShapeSelector gradient(String startColor, String endColor) {
        this.isGradient = true;
        this.gradientColors = new int[2];
        this.gradientColors[0] = Color.parseColor(startColor);
        this.gradientColors[1] = Color.parseColor(endColor);
        this.gradientType = GradientDrawable.LINEAR_GRADIENT;
        this.gradientOrientation = TOP_BOTTOM;
        return this;
    }


    /**
     * 线性渐变样式
     * 默认方向 从上到下渐变 GradientDrawable.Orientation.TOP_BOTTOM
     *
     * @param gradientColorsResId 渐变颜色数组 数组元素 例：R.color.colorPrimary
     * @return BaseShape
     */
    public ShapeSelector gradientLinear(@ColorRes int... gradientColorsResId) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.LINEAR_GRADIENT;
        this.gradientOrientation = TOP_BOTTOM;
        if (gradientColorsResId.length > 1) {
            this.gradientColors = new int[gradientColorsResId.length];
            for (int i = 0; i < gradientColorsResId.length; i++) {
                this.gradientColors[i] = XSelector.getContext().getResources().getColor(gradientColorsResId[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 线性渐变样式
     * 默认方向 从上到下渐变 TOP_BOTTOM
     *
     * @param gradientColorsResId 渐变颜色数组 数组元素 例：#ffffff
     * @return BaseShape
     */
    public ShapeSelector gradientLinear(String... gradientColorsResId) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.LINEAR_GRADIENT;
        this.gradientOrientation = TOP_BOTTOM;
        if (gradientColorsResId.length > 1) {
            this.gradientColors = new int[gradientColorsResId.length];
            for (int i = 0; i < gradientColorsResId.length; i++) {
                this.gradientColors[i] = Color.parseColor(gradientColorsResId[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 线性渐变样式
     *
     * @param gradientColorsResId 渐变颜色数组 数组元素 例：R.color.colorPrimary
     * @param gradientOrientation 渐变方向
     * @return BaseShape
     */
    public ShapeSelector gradientLinear(@GradientOrientation String gradientOrientation, @ColorRes int... gradientColorsResId) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.LINEAR_GRADIENT;
        this.gradientOrientation = gradientOrientation;
        if (gradientColorsResId.length > 1) {
            this.gradientColors = new int[gradientColorsResId.length];
            for (int i = 0; i < gradientColorsResId.length; i++) {
                this.gradientColors[i] = XSelector.getContext().getResources().getColor(gradientColorsResId[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 线性渐变样式
     *
     * @param gradientColors      渐变颜色数组 数组元素 例：#ffffff
     * @param gradientOrientation 渐变方向
     * @return BaseShape
     */
    public ShapeSelector gradientLinear(@GradientOrientation String gradientOrientation, String... gradientColors) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.LINEAR_GRADIENT;
        this.gradientOrientation = gradientOrientation;
        if (gradientColors.length > 1) {
            this.gradientColors = new int[gradientColors.length];
            for (int i = 0; i < gradientColors.length; i++) {
                this.gradientColors[i] = Color.parseColor(gradientColors[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 扫描渐变样式
     *
     * @param gradientColors 渐变颜色数组 数组元素 例：R.color.colorPrimary
     * @return BaseShape
     */
    public ShapeSelector gradientSweep(int... gradientColors) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.SWEEP_GRADIENT;
        if (gradientColors.length > 1) {
            this.gradientColors = new int[gradientColors.length];
            for (int i = 0; i < gradientColors.length; i++) {
                this.gradientColors[i] = XSelector.getContext().getResources().getColor(gradientColors[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 扫描渐变样式
     *
     * @param gradientColors 渐变颜色数组 数组元素 例：#ffffff
     * @return BaseShape
     */
    public ShapeSelector gradientSweep(String... gradientColors) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.SWEEP_GRADIENT;
        if (gradientColors.length > 1) {
            this.gradientColors = new int[gradientColors.length];
            for (int i = 0; i < gradientColors.length; i++) {
                this.gradientColors[i] = Color.parseColor(gradientColors[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 辐射渐变样式
     *
     * @param gradientColors 渐变颜色数组 数组元素 例：R.color.colorPrimary
     * @return BaseShape
     */
    public ShapeSelector gradientRadial(float radialRadius, int... gradientColors) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.RADIAL_GRADIENT;
        this.radialRadius = radialRadius;
        if (gradientColors.length > 1) {
            this.gradientColors = new int[gradientColors.length];
            for (int i = 0; i < gradientColors.length; i++) {
                this.gradientColors[i] = XSelector.getContext().getResources().getColor(gradientColors[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 辐射渐变样式
     *
     * @param gradientColors 渐变颜色数组 数组元素 例：#ffffff
     * @param radialRadius   辐射渐变半径
     * @return BaseShape
     */
    public ShapeSelector gradientRadial(float radialRadius, String... gradientColors) {
        this.isGradient = true;
        this.gradientType = GradientDrawable.RADIAL_GRADIENT;
        this.radialRadius = radialRadius;
        if (gradientColors.length > 1) {
            this.gradientColors = new int[gradientColors.length];
            for (int i = 0; i < gradientColors.length; i++) {
                this.gradientColors[i] = Color.parseColor(gradientColors[i]);
            }
        } else {
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return this;
    }


    /**
     * 设置圆角弧度 默认设置4个圆角
     *
     * @param radius 圆角弧度
     */
    public ShapeSelector radius(float radius) {
        this.isRadius = true;
        this.topRightRadius = radius;
        this.topLeftRadius = radius;
        this.bottomRightRadius = radius;
        this.bottomLeftRadius = radius;
        return this;
    }

    /**
     * 设置右上圆角
     *
     * @param topRightRadius 圆角弧度
     * @return ShapeSelector
     */
    public ShapeSelector trRadius(float topRightRadius) {
        this.isRadius = true;
        this.topRightRadius = topRightRadius;
        return this;
    }


    /**
     * 设置左上圆角
     *
     * @param topLeftRadius 圆角弧度
     * @return ShapeSelector
     */
    public ShapeSelector tlRadius(float topLeftRadius) {
        this.isRadius = true;
        this.topLeftRadius = topLeftRadius;
        return this;
    }


    /**
     * 设置右下圆角
     *
     * @param bottomRightRadius 圆角弧度
     * @return ShapeSelector
     */
    public ShapeSelector brRadius(float bottomRightRadius) {
        this.isRadius = true;
        this.bottomRightRadius = bottomRightRadius;
        return this;
    }

    /**
     * 设置左下圆角
     *
     * @param bottomLeftRadius 圆角弧度
     * @return ShapeSelector
     */
    public ShapeSelector blRadius(float bottomLeftRadius) {
        this.isRadius = true;
        this.bottomLeftRadius = bottomLeftRadius;
        return this;
    }

    @Override
    public void into(View view) {
        if (isBackgroundColor){ //针对selector作用无效问题
            view.setClickable(true);
        }
        view.setBackground(createShape());
    }

    @Override
    public Drawable build() {
        return createShape();
    }


    /**
     * 生成样式
     *
     * @return Drawable
     */
    private StateListDrawable createShape() {
        StateListDrawable selector = new StateListDrawable();
        //enabled = false
        if (hasSetDisabledBgColor || hasSetDisabledStrokeColor) {
            GradientDrawable disabledShape = getItemShape(mShape,
                    mDisabledBgColor, mDisabledStrokeColor, dashLineColor);
            selector.addState(new int[]{-android.R.attr.state_enabled}, disabledShape);
        }

        //pressed = true
        if (hasSetPressedBgColor || hasSetPressedStrokeColor) {
            GradientDrawable pressedShape = getItemShape(mShape,
                    mPressedBgColor, mPressedStrokeColor, dashLineColor);
            selector.addState(new int[]{android.R.attr.state_pressed}, pressedShape);
        }

        //selected = true
        if (hasSetSelectedBgColor || hasSetSelectedStrokeColor) {
            GradientDrawable selectedShape = getItemShape(mShape,
                    mSelectedBgColor,mSelectedStrokeColor , dashLineColor);
            selector.addState(new int[]{android.R.attr.state_selected}, selectedShape);
        }

        //focused = true
        if (hasSetFocusedBgColor || hasSetFocusedStrokeColor) {
            GradientDrawable focusedShape = getItemShape(mShape,
                    mFocusedBgColor, mFocusedStrokeColor, dashLineColor);
            selector.addState(new int[]{android.R.attr.state_focused}, focusedShape);
        }

        //default
        GradientDrawable defaultShape = getItemShape(mShape,
                mDefaultBgColor, mDefaultStrokeColor, dashLineColor);
        selector.addState(new int[]{}, defaultShape);

        return selector;
    }

    /**
     * 设置线性渐变方向
     *
     * @return GradientDrawable.Orientation
     */
    private GradientDrawable.Orientation createGradientOrientation() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        switch (gradientOrientation) {
            case TOP_BOTTOM:
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            case TR_BL:
                orientation = GradientDrawable.Orientation.TR_BL;
                break;
            case RIGHT_LEFT:
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                break;
            case BR_TL:
                orientation = GradientDrawable.Orientation.BR_TL;
                break;
            case BOTTOM_TOP:
                orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                break;
            case BL_TR:
                orientation = GradientDrawable.Orientation.BL_TR;
                break;
            case LEFT_RIGHT:
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            case TL_BR:
                orientation = GradientDrawable.Orientation.TL_BR;
                break;

        }
        return orientation;
    }


    /**
     * 单位转换工具类
     *
     * @param dipValue 值
     * @return 返回值
     */
    private int dip2px(float dipValue) {
        final float scale = XSelector.getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    private GradientDrawable getItemShape(int shape, int solidColor, int lineColor, int dashLineColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(shape);
        if (isRadius) {
            float[] radii = {dip2px(topLeftRadius), dip2px(topLeftRadius),
                    dip2px(topRightRadius), dip2px(topRightRadius),
                    dip2px(bottomRightRadius), dip2px(bottomRightRadius),
                    dip2px(bottomLeftRadius), dip2px(bottomLeftRadius)};
            drawable.setCornerRadii(radii);//设置圆角
        }

        if (isBackgroundColor) {
            drawable.setColor(solidColor);// 设置背景颜色
        }

        if (isLine) {
            drawable.setStroke(dip2px(lineWidth), lineColor);// 设置边框线
        }

        if (isDashLine) {
            drawable.setStroke(dip2px(dashLineWidth), dashLineColor, dip2px(dashWidth), dip2px(dashGap));//设置虚线
        }

        if (isGradient) {
            switch (gradientType) {
                case GradientDrawable.LINEAR_GRADIENT:
                    drawable.setOrientation(createGradientOrientation());//设置线性渐变方向
                    break;
                case GradientDrawable.RADIAL_GRADIENT:
                    drawable.setGradientRadius(dip2px(radialRadius));//设置辐射渐变辐射范围半径
                    break;
                case GradientDrawable.SWEEP_GRADIENT:
                    break;

            }
            drawable.setGradientType(gradientType);
            drawable.setColors(gradientColors);
        }

        return drawable;
    }

}
