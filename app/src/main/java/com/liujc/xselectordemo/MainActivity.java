package com.liujc.xselectordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.xselector.XSelector;
import com.android.xselector.selector.ColorSelector;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button btn1, btn2, btn3, btn4, btn_shape;
    TextView tv1, tv2, tv3, tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn_shape = (Button) findViewById(R.id.btn_shape);
        btn_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShapeActivity.class));
            }
        });

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        initEditText();
        initButton();
        initTextView();
    }

    private void initEditText() {
//      为EditText设置边框、背景色
        XSelector.shapeSelector()
                .defaultBgColor(R.color.white)
                .defaultStrokeColor(R.color.gray)
                .focusedBgColor(R.color.yellow)
                .focusedStrokeColor(R.color.yellow)
                .strokeWidth(2)
                .into(et1);

        XSelector.shapeSelector()
                .defaultStrokeColor(R.color.gray)
                .focusedStrokeColor(R.color.yellow)
                .strokeWidth(2)
                .radius(5)
                .into(et2);
        XSelector.shapeSelector()
                .defaultStrokeColor(R.color.gray)
                .focusedStrokeColor(R.color.red)
                .strokeWidth(2)
                .into(et3);
//      为EditText中的文字设置在不同触摸状态的HintTextColor
        XSelector.colorSelector()
                .defaultColor(R.color.gray)
                .focusedColor(R.color.red)
                .textType(ColorSelector.HINT_TEXT_COLOR)
                .into(et1);
        XSelector.colorSelector()
                .defaultColor(R.color.gray)
                .focusedColor(R.color.black)
                .textType(ColorSelector.HINT_TEXT_COLOR)
                .into(et2);
        XSelector.colorSelector()
                .defaultColor(R.color.gray)
                .focusedColor(R.color.black)
                .textType(ColorSelector.HINT_TEXT_COLOR)
                .into(et3);

//      为EditText中的文字设置在不同触摸状态的TextColor
        XSelector.colorSelector()
                .defaultColor(R.color.gray)
                .focusedColor(R.color.black)
                .into(et1);
        XSelector.colorSelector()
                .defaultColor(R.color.black)
                .focusedColor(R.color.yellow)
                .into(et2);
        XSelector.colorSelector()
                .defaultColor(R.color.gray)
                .focusedColor(R.color.red)
                .into(et3);
    }

    private void initButton() {
//      为Button设置不同触摸状态的背景色
        XSelector.drawableSelector()
                .defaultDrawable(R.mipmap.blue_primary)
                .pressedDrawable(R.mipmap.blue_primary_dark)
                .into(btn1);
        XSelector.shapeSelector()
                .defaultBgColor(android.R.color.holo_blue_light)
                .pressedBgColor(android.R.color.holo_blue_dark)
                .into(btn2);
        XSelector.shapeSelector()
                .defaultBgColor(android.R.color.holo_blue_light)
                .pressedBgColor(android.R.color.holo_blue_dark)
                .selectedBgColor(android.R.color.holo_blue_dark)
                .radius(5)
                .into(btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3.setSelected(!btn3.isSelected());
            }
        });
        XSelector.shapeSelector()
                .defaultBgColor(android.R.color.holo_blue_light)
                .pressedBgColor(android.R.color.holo_blue_dark)
                .disabledBgColor(R.color.gray)
                .into(btn4);
        btn4.setEnabled(false);
    }

    private void initTextView() {
//      为TextView设置不同触摸状态的边框、背景色、文字颜色
        XSelector.shapeSelector()
                .defaultStrokeColor(R.color.gray)
                .strokeWidth(1)
                .radius(5)
                .into(tv1);
        XSelector.colorSelector()
                .defaultColor(R.color.black)
                .pressedColor(R.color.red)
                .into(tv2);
        XSelector.colorSelector()
                .defaultColor(R.color.black)
                .selectedColor(R.color.red)
                .into(tv3);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv3.setSelected(!tv3.isSelected());
            }
        });
        XSelector.colorSelector()
                .defaultColor(R.color.black)
                .selectedColor(R.color.yellow)
                .disabledColor(R.color.gray)
                .into(tv4);
        tv4.setEnabled(false);
    }
}
