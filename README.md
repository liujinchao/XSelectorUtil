# XSelectorUtil
一个可以用代码在TextView、EditText、Button等控件设置selector背景（触摸反馈，样式变化、文字颜色变化、hint文字颜色变化等效果）的组件

**目的：**
XSelector工具旨在解决项目中selector.xml文件随着需求的增加不断增多的问题，创造一个可以用代码在TextView、EditText、Button等控件设置selector背景（触摸反馈，样式变化、文字颜色变化、hint文字颜色变化等效果）的组件, 再也不用写selector.xml了，瞬间感觉好爽歪歪啊，如若感觉对你还有帮助，希望star一下。

**先来看下XSelector能实现哪些效果，如下图所示（包含图中样式但不限于这些样式哦）：**

![drawable_and_color.gif](https://github.com/liujinchao/XSelectorUtil/blob/master/screenshot/drawable_and_color2.gif)
![shape_selector.gif](https://github.com/liujinchao/XSelectorUtil/blob/master/screenshot/shape_selector2.gif)


## XSelector如何使用

把工具类引入到项目中：`compile 'com.android.util:xselector:1.0.1'`。

## 初始化：
在Application中进行初始化: `XSelector.init(this);`

## 工具相关使用方法
   ****
1. **ShapeSelector**
     + 圆形边框
        ```
        TextView tv_oval_line = (TextView) findViewById(R.id.tv_oval_line);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.OVAL)
                .defaultBgColor(R.color.colorAccent)
                .defaultStrokeColor(R.color.colorAccent)
                .strokeWidth(1)
                .into(tv_oval_line);
        ```
    + 方形虚线圆角边框
      ```
        TextView tv_rect_dash_line_radius = (TextView)findViewById(R.id.tv_rect_dash_line_radius);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .dashLine(1, R.color.colorPrimary, 5, 5)
                .radius(5)
                .into(tv_rect_dash_line_radius);

         TextView tv_rect_diagonal2 =  (TextView)findViewById(R.id.tv_rect_diagonal2);
         XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .defaultBgColor(R.color.colorAccent)
                .trRadius(10)
                .blRadius(10)
                .into(tv_rect_diagonal2);
      ```
     + 触摸反馈
       ```
        TextView tv_oval_solid = (TextView) findViewById(R.id.tv_oval_solid);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.OVAL)
                .defaultBgColor(R.color.colorAccent)
                .pressedBgColor(R.color.colorPrimary)
                .into(tv_oval_solid);
       ```
   + 渐变效果
      ```
        TextView tv_gradient_linear_tb =  (TextView)findViewById(R.id.tv_gradient_linear_tb);
        XSelector.shapeSelector()
                .setShape(GradientDrawable.RECTANGLE)
                .gradientLinear(ShapeSelector.TOP_BOTTOM, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_tb);

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
      ```
   **详细方法名如下：**

     |方法名     |                                	          描述          |
     |:---|:---:|
     |setShape(@Shape int shape)              	    |    边框背景形状        |
     |defaultBgColor/disabledBgColor|默认背景颜色|
     |disabledBgColor|不可点击背景色|
     |pressedBgColor|触摸背景色|
     |selectedBgColor|选中背景色|
     |focusedBgColor	|获取焦点背景色|
     |strokeWidth                             	        | 边框宽度         |
     |defaultStrokeColor	        |默认边框颜色  |
     |disabledStrokeColor|不可点击边框背景色|
     |pressedStrokeColor|触摸边框背景色|
     |selectedStrokeColor|选中边框背景色|
     |focusedStrokeColor	        |获取焦点边框背景色|
     |dashLine                   |             	        边框虚线样式        |
     |gradient                             |   	         渐变样式   |      
     |gradientLinear           |               	        线性渐变样式       |
     |gradientSweep            |               	        扫描渐变样式        |
     |gradientRadial             |             	        辐射渐变样式        |
     |radius                           |       	        设置圆角弧度        |
     |trRadius/tlRadius/brRadius/blRadius    | 	   设置右上圆角/左上/右下/左下 |   
     |build                             |      	     生成样式Drawable  |   
     |into                              |      	       填充目标View       |
      ****                                          	                      
  
2. **ColorSelector和DrawableSelector**      
    +  作用在TextView
         ```
        XSelector.colorSelector()
                .defaultColor(R.color.black)
                .selectedColor(R.color.yellow)
                .disabledColor(R.color.gray)
                .into(tv4);
         ```
    +  作用在EditText
         ```
         //作用在setTextColor
        XSelector.colorSelector()
                .defaultColor(R.color.gray)
                .focusedColor(R.color.black)
                .into(et1);
        //作用在setHintTextColor
        XSelector.colorSelector()
                .defaultColor(R.color.gray)
                .focusedColor(R.color.white)
                .textType(ColorSelector.HINT_TEXT_COLOR)
                .into(et1);
         ```
    +  作用在Button
         ```
        XSelector.drawableSelector()
                .defaultDrawable(R.mipmap.blue_primary)
                .pressedDrawable(R.mipmap.blue_primary_dark)
                .into(btn1);
         ```
     使用方法存在但不限于上述使用方法，具体详细方法如下：

     |模块|方法名|描述|
     |:---|:---|:---:|
     |ColorSelector|defaultColor|默认颜色|
     ||disabledColor|不可点击|
     ||pressedColor|触摸|
     ||selectedColor|选中|
     ||focusedColor|获取焦点|
     ||textType|设置类型：TextColor（默认）、HintTextColor|
     ||build|状态集合ColorStateList|
     ||into|目标View|
     |DrawableSelector|defaultDrawable|默认
      ||disabledDrawable|不可点击|
     ||pressedDrawable|触摸|
     ||selectedDrawable|选中|
     ||focusedDrawable|获取焦点|
     ||build|背景Drawable|
     ||into|目标View|

