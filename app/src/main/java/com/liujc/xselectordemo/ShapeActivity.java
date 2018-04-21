package com.liujc.xselectordemo;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.android.xselector.XSelector;
import com.android.xselector.selector.ShapeSelector;


/**
 * 类名称：ShapeActivity
 * 创建者：Create by liujc
 * 创建时间：Create on 2018/4/16 22:20
 * 描述：ShapeSelector 的使用
 */
public class ShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        initView();
    }


    private void initView() {
        //圆形
        TextView tv_oval_solid = (TextView) findViewById(R.id.tv_oval_solid);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.OVAL)
                .defaultBgColor(R.color.colorAccent)
                .pressedBgColor(R.color.colorPrimary)
                .into(tv_oval_solid);
        TextView tv_oval_line = (TextView) findViewById(R.id.tv_oval_line);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.OVAL)
                .defaultBgColor(R.color.colorAccent)
                .defaultStrokeColor(R.color.colorAccent)
                .strokeWidth(1)
                .into(tv_oval_line);
        TextView tv_oval_dash_line = (TextView)findViewById(R.id.tv_oval_dash_line);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.OVAL)
                .defaultBgColor(R.color.colorAccent)
                .dashLine(1, R.color.colorPrimary, 5, 5)
                .into(tv_oval_dash_line);
        //矩形
        TextView tv_rect_solid_radius = (TextView)findViewById(R.id.tv_rect_solid_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .radius(5)
                .into(tv_rect_solid_radius);
        TextView tv_rect_line_radius = (TextView)findViewById(R.id.tv_rect_line_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .defaultStrokeColor(R.color.colorAccent)
                .strokeWidth(1)
                .radius(5)
                .into(tv_rect_line_radius);
        TextView tv_rect_dash_line_radius = (TextView)findViewById(R.id.tv_rect_dash_line_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .dashLine(1, R.color.colorPrimary, 5, 5)
                .radius(5)
                .into(tv_rect_dash_line_radius);
        //圆角（常用）
        TextView tv_rect_solid = (TextView)findViewById(R.id.tv_rect_solid);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .radius(999)
                .into(tv_rect_solid);
        TextView tv_rect_line = (TextView)findViewById(R.id.tv_rect_line);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultStrokeColor(R.color.colorAccent)
                .strokeWidth(1)
                .radius(999)
                .into(tv_rect_line);
        //触摸反馈
        Button btn_selector_background = (Button) findViewById(R.id.btn_selector_background);
        XSelector.selectorBackground(
                XSelector.shapeSelector().setShape(GradientDrawable.RECTANGLE).defaultBgColor(R.color.colorPrimary).radius(999).build(),
                XSelector.shapeSelector().setShape(GradientDrawable.RECTANGLE).defaultBgColor(R.color.colorAccent).radius(999).build())
                .into(btn_selector_background);
        Button btn_selector_background_color = (Button)findViewById(R.id.btn_selector_background_color);
        XSelector.selectorBackground(
                XSelector.shapeSelector().setShape(GradientDrawable.RECTANGLE).defaultBgColor(R.color.colorPrimary).radius(999).build(),
                XSelector.shapeSelector().setShape(GradientDrawable.RECTANGLE).defaultBgColor(R.color.colorAccent).radius(999).build())
                .selectorColor("#ffffff", "#000000")
                .into(btn_selector_background_color);
        //圆角
        TextView tv_rect_top_radius =  (TextView)findViewById(R.id.tv_rect_top_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .tlRadius(10)
                .trRadius(10)
                .into(tv_rect_top_radius);
        TextView tv_rect_bottom_radius = (TextView) findViewById(R.id.tv_rect_bottom_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .blRadius(10)
                .brRadius(10)
                .into(tv_rect_bottom_radius);
        TextView tv_rect_diagonal1 =  (TextView)findViewById(R.id.tv_rect_diagonal1);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .tlRadius(10)
                .brRadius(10)
                .into(tv_rect_diagonal1);
        TextView tv_rect_diagonal2 =  (TextView)findViewById(R.id.tv_rect_diagonal2);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .trRadius(10)
                .blRadius(10)
                .into(tv_rect_diagonal2);
        TextView tv_rect_tl_radius =  (TextView)findViewById(R.id.tv_rect_tl_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .tlRadius(10)
                .into(tv_rect_tl_radius);
        TextView tv_rect_tr_radius =  (TextView)findViewById(R.id.tv_rect_tr_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .trRadius(10)
                .into(tv_rect_tr_radius);
        TextView tv_rect_bl_radius =  (TextView)findViewById(R.id.tv_rect_bl_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .blRadius(10)
                .into(tv_rect_bl_radius);
        TextView tv_rect_br_radius = (TextView) findViewById(R.id.tv_rect_br_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .brRadius(10)
                .into(tv_rect_br_radius);
        //渐变
        TextView tv_gradient_linear_tb =  (TextView)findViewById(R.id.tv_gradient_linear_tb);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .gradientLinear(ShapeSelector.TOP_BOTTOM, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_tb);
        TextView tv_gradient_linear_bt =  (TextView)findViewById(R.id.tv_gradient_linear_bt);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .gradientLinear(ShapeSelector.BOTTOM_TOP, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_bt);
        TextView tv_gradient_linear_lr =  (TextView)findViewById(R.id.tv_gradient_linear_lr);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .gradientLinear(ShapeSelector.LEFT_RIGHT, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_lr);
        TextView tv_gradient_linear_rl =  (TextView)findViewById(R.id.tv_gradient_linear_rl);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .gradientLinear(ShapeSelector.RIGHT_LEFT, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_rl);
        TextView tv_gradient_sweep =  (TextView)findViewById(R.id.tv_gradient_sweep);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.OVAL)
                .gradientSweep(R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_sweep);
        TextView tv_gradient_radial =  (TextView)findViewById(R.id.tv_gradient_radial);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.OVAL)
                .gradientRadial(30, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_radial);
    }
}
