package com.liujc.xselectordemo;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.xselector.XSelector;
import com.android.xselector.shadow.ShadowHelper;

public class ShadowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);
        initShadowDrawable();
    }

    private void initShadowDrawable() {
        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        TextView textView3 = findViewById(R.id.text3);
        TextView textView4 = findViewById(R.id.text4);
        TextView textView5 = findViewById(R.id.text5);

        XSelector.shadowHelper().setBgColor(Color.parseColor("#3D5AFE"))
                .setShapeRadius(dpToPx(8))
                .setShadowColor(Color.parseColor("#66000000"))
                .setShadowRadius(dpToPx(20))
                .setShadowSide(ShadowHelper.ALL)
                .setOffsetX(0)
                .setOffsetY(0)
                .into(textView1);
        XSelector.shadowHelper().setBgColor(Color.parseColor("#2979FF"))
                .setShapeRadius(dpToPx(8))
                .setShadowColor(Color.parseColor("#992979FF"))
                .setShadowRadius(dpToPx(6))
                .setOffsetX(0)
                .setOffsetY(dpToPx(4))
                .into(textView2);
        XSelector.shadowHelper().setBgColor(new int[] {
                Color.parseColor("#536DFE"), Color.parseColor("#7C4DFF")})
                .setShapeRadius(dpToPx(8))
                .setShadowSide(ShadowHelper.ALL)
                .setShadowColor(Color.parseColor("#997C4DFF"))
                .setShadowRadius(dpToPx(5))
                .setOffsetX(dpToPx(5))
                .setOffsetY(dpToPx(5))
                .into(textView3);

        XSelector.shadowHelper().setShape(ShadowHelper.SHAPE_CIRCLE)
                .setBgColor(Color.parseColor("#1DE9B6"))
                .setShadowColor(Color.parseColor("#99FF3D00"))
                .setShadowRadius(dpToPx(8))
                .into(textView4);
        XSelector.shadowHelper().setShape(ShadowHelper.SHAPE_CIRCLE)
                .setBgColor(Color.parseColor("#FF3D00"))
                .setShapeRadius(dpToPx(8))
                .setShadowColor(Color.parseColor("#991DE9B6"))
                .setShadowRadius(dpToPx(6))
                .setOffsetX(dpToPx(4))
                .setOffsetY(dpToPx(4))
                .into(textView5);

        View bg = findViewById(R.id.rl_bg);
        XSelector.shadowHelper()
                .setShapeRadius(dpToPx(8))
                .setBgColor(Color.parseColor("#1DE9B6"))
                .setShadowColor(Color.parseColor("#4DA65740"))
                .setShadowRadius(dpToPx(8))
                .setOffsetY(dpToPx(5))
                .into(bg);
    }

    private int dpToPx(int dp) {
        return (int) (Resources.getSystem().getDisplayMetrics().density * dp + 0.5f);
    }
}
