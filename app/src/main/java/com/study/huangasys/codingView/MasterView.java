package com.study.huangasys.codingView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author huangasys
 * @date 2018/11/7
 * Created by huangasys on 2018/11/7.17:05
 * @Describe:
 */

public class MasterView extends View {


    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private int mRadius = 100;
    private ValueAnimator mValueAnimator;
    private int x = 0;


    public MasterView(Context context) {
        this(context, null);
    }

    public MasterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MasterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        startValueAnimator();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawArc(mWidth / 2 - mRadius, mHeight / 2 - mRadius, mWidth / 2 + mRadius, mHeight / 2 + mRadius, 30 - x, 300+ x*2, true, mPaint);
    }

    private void startValueAnimator() {
        mValueAnimator = ValueAnimator.ofInt(0, 30);
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mValueAnimator.setRepeatCount(-1);
        mValueAnimator.setDuration(3000);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                x = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        mValueAnimator.start();
    }
}
