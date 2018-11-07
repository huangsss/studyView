package com.study.huangasys.codingView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author huangasys
 * @date 2018/11/5
 * Created by huangasys on 2018/11/5.15:21
 * @Describe:
 */

public class FluctuateView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private int mRadius = 200;
    private int mTmpPointCount;
    private Path mPath;

    private ValueAnimator mValueAnimator;


    public FluctuateView(Context context) {
        this(context, null);
    }

    public FluctuateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FluctuateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        startAnimator();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            mWidth = w;
            mHeight = h;
        }
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    private void startAnimator() {
        mValueAnimator = ValueAnimator.ofInt(3, 15);
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mValueAnimator.setRepeatCount(-1);
        mValueAnimator.setDuration(5000);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mTmpPointCount = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        mValueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath = new Path();
        //计算每个点之间的间隔角度
        double angle = 2.0 * Math.PI / mTmpPointCount;
        //移动到路径起点
        mPath.moveTo(
                mWidth / 2 + (float) (mRadius * Math.cos(0.0)),
                mHeight / 2 + (float) (mRadius * Math.sin(0.0)));
        //依次连接多边形顶点
        for (int i = 1; i < mTmpPointCount + 1; i++) {
            mPath.lineTo(
                    mWidth / 2 + (float) (mRadius * Math.cos(angle * i)),
                    mHeight / 2 + (float) (mRadius * Math.sin(angle * i)));
        }
        //闭合Path
        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }
}
