package com.study.huangasys.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by "huangsays" "健" on 2017/3/16.15:05"huangays@gmail.com"
 */

public class DrawsView extends View {

    //创建一个画笔;

    private Paint mPaint;

    public DrawsView(Context context) {
        this(context, null);
    }

    public DrawsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);//设置画笔的颜色;
        mPaint.setStyle(Paint.Style.FILL);//设置画笔的模式为填充;Stroke则为空心;
        mPaint.setStrokeWidth(10f);//设置画笔的宽度为10px;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 1)画点;
         */
//        canvas.drawPoint(200,200,mPaint);//在坐标为200,200的地方绘制一个点；
//        canvas.drawPoints(new float[]{
//                500,600,
//                500,700,
//                500,800
//        },mPaint);
        /**
         * 2)画直线;
         */
//        canvas.drawLine(300,300,600,600,mPaint); // 在坐标(300,300)(600,600)之间绘制一条直线
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                100,200,200,200,
//                100,300,200,300
//        },mPaint);
        /**
         *3)画矩形;
         * 确定一个矩形最少需要四个数据，就是对角线的两个点的坐标值，这里一般采用左上角和右下角的两个点的坐标。
         */
//        canvas.drawRect(100, 100, 800, 400, mPaint);//第一种
     /*
        Rect rect = new Rect(100,100,800,400);
        RectF rectF = new RectF(100,100,800,400);//两者最大的区别就是精度不同，Rect是int(整形)的，而RectF是float(单精度浮点型)的.
        canvas.drawRect(rect,mPaint);*/
        /**
         *4)画圆角矩形;
         * 际上在rx为宽度的一半，ry为高度的一半时，刚好是一个椭圆，通过上面我们分析的原理推算一下就能得到，
         * 而当rx大于宽度的一半，ry大于高度的一半时，实际上是无法计算出圆弧的，
         * 所以drawRoundRect对大于该数值的参数进行了限制(修正)，凡是大于一半的参数均按照一半来处理
         */
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawRoundRect(rectF,30,30,mPaint);//参数rx,ry;这里圆角矩形的角实际上不是一个正圆的圆弧，而是椭圆的圆弧，这里的两个参数实际上是椭圆的两个半径
        /**
         * 5)画椭圆；
         */
        //第一种;
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawOval(rectF,mPaint);

//        canvas.drawOval(100,100,800,400,mPaint);

        /**
         * 6)画圆形;
         */
//        canvas.drawCircle(600,600,30f,mPaint);
        /**
         * 画弧度;
         *  startAngle  // 开始角度
         sweepAngle  // 扫过角度
         useCenter   // 是否使用中心
         */
        //绘制背景矩形;
        mPaint.setColor(Color.GRAY);
        RectF rectF = new RectF(100,100,600,600);
        canvas.drawRect(rectF,mPaint);
        //绘制弧度;
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF,0,90,true,mPaint);//绘制圆弧;


        super.onDraw(canvas);//目前不知道有啥作用;
    }
}
