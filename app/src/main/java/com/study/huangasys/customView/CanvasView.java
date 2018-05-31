package com.study.huangasys.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangasys on 2017/12/6.19:02
 */

public class CanvasView extends View {

    private Paint mPaint;


    private int mWidth;
    private int mHeight;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        this.mWidth = MeasureSpec.getSize(widthMeasureSpec);
        this.mHeight = MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {

      /*  mPaint.setColor(Color.BLUE);
        //基于当前位置平移,
        canvas.translate(200, 200);
        canvas.drawCircle(0, 0, 100, mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.translate(200, 200);
        canvas.drawCircle(0, 0, 100, mPaint);
*/


//        canvas.translate(400,400);
/*
        Log.d("print", "onDraw: "+mWidth+"sss"+mHeight);
        Rect rect = new Rect(100, 100, 800, 400);
        canvas.drawRect(rect, mPaint);
*/
/**
 * 旋转
 */
        /*mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.translate(mWidth / 2, mHeight / 2);//平移坐标点至屏幕中心;
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);

        mPaint.setColor(Color.BLUE);
        //canvas.rotate(180);//旋转角度;默认对应中心左边点;
        canvas.rotate(180,200,0);//旋转角度,以及旋转对应的中心点;
        canvas.drawRect(rectF, mPaint);*/

        /**
         * 旋转 调用两次旋转，则实际的旋转角度为xx+yy度。
         */
        canvas.translate(mWidth/2,mHeight/2);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(0,0,400,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(0,0,380,mPaint);

        mPaint.setColor(Color.BLACK);
        for (int i = 0; i < 360; i++) {
            canvas.drawLine(0,380,0,400,mPaint);
            canvas.rotate(10);
        }


        super.onDraw(canvas);
    }
}
