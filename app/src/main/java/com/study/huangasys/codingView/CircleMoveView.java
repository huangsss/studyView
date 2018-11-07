package com.study.huangasys.codingView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author huangasys
 * @date 2018/11/4
 * Created by huangasys on 2018/11/4.17:00
 * @Describe:
 */

public class CircleMoveView extends View {

    private Paint mPaint;
    private Path mPath;


    private int mWidth;
    private int mHeight;

    private int mRadius = 200;
    private ValueAnimator mValueAnimator;
    private float x = 0f;

    public CircleMoveView(Context context) {
        this(context, null);
    }

    public CircleMoveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

        startAnimator();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        canvas.drawArc(new RectF(mWidth/2-mRadius,mHeight/2-mRadius,mWidth/2+mRadius,mHeight/2+mRadius),180,90,true,mPaint);
        //1
        initPaths();
        mPaint.setColor(Color.parseColor("#FD9A59"));
        canvas.drawPath(mPath, mPaint);

        //2
        init2Paths();
        mPaint.setColor(Color.parseColor("#FD9B90"));
        canvas.drawPath(mPath, mPaint);
        //3
        init3Paths();
        mPaint.setColor(Color.parseColor("#FD9D80"));
        canvas.drawPath(mPath, mPaint);
        //4
        init4Paths();
        mPaint.setColor(Color.parseColor("#FD9C50"));
        canvas.drawPath(mPath, mPaint);
    }

    /**
     * A(mWidth/2,mHeight/2 - R)
     * B(mWidth/2 - R,mHeight/2)
     * P(mWidth/2 - x,mHeight/2 - x)
     */
    private void initPaths() {
        mPath.reset();//清空上一次的路径
        //移动到B点
        mPath.moveTo(mWidth/2-mRadius,mHeight/2);
        //绘制圆弧
        mPath.addArc(new RectF(mWidth/2-mRadius,mHeight/2-mRadius,mWidth/2+mRadius,mHeight/2+mRadius),180,90);
        //绘制ap
        mPath.lineTo(mWidth/2-x,mHeight/2-x);
        //闭合曲线
        mPath.close();
    }
    private void init2Paths() {
        mPath.reset();//清空上一次的路径
        //移动到B点
        mPath.moveTo(mWidth/2+mRadius,mHeight/2);
        //绘制圆弧
        mPath.addArc(new RectF(mWidth/2-mRadius,mHeight/2-mRadius,mWidth/2+mRadius,mHeight/2+mRadius),360,-90);
        //绘制ap
        mPath.lineTo(mWidth/2+x,mHeight/2-x);
        //闭合曲线
        mPath.close();
    }
    private void init3Paths() {
        mPath.reset();//清空上一次的路径
        //移动到B点
        mPath.moveTo(mWidth/2-mRadius,mHeight/2);
        //绘制圆弧
        mPath.addArc(new RectF(mWidth/2-mRadius,mHeight/2-mRadius,mWidth/2+mRadius,mHeight/2+mRadius),180,-90);
        //绘制ap
        mPath.lineTo(mWidth/2-x,mHeight/2+x);
        //闭合曲线
        mPath.close();
    }

    private void init4Paths() {
        mPath.reset();//清空上一次的路径
        //移动到B点
        mPath.moveTo(mWidth/2+mRadius,mHeight/2);
        //绘制圆弧
        mPath.addArc(new RectF(mWidth/2-mRadius,mHeight/2-mRadius,mWidth/2+mRadius,mHeight/2+mRadius),360,90);
        //绘制ap
        mPath.lineTo(mWidth/2+x,mHeight/2+x);
        //闭合曲线
        mPath.close();
    }
    private void startAnimator(){
        mValueAnimator = ValueAnimator.ofFloat(0,mRadius/2f);
        //设置动画重复模式，REVERSE--反转，RESTART--重新开始
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //次数 无限次
        mValueAnimator.setRepeatCount(-1);
        mValueAnimator.setDuration(5000);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //更新P的坐标
                x = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        mValueAnimator.start();
    }
}
