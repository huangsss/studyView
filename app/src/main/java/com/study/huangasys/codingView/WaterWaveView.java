package com.study.huangasys.codingView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author huangasys
 * @date 2018/11/4
 * Created by huangasys on 2018/11/4.14:25
 * @Describe:
 */

public class WaterWaveView extends View {


    /**
     * 绘制最中心圆的Paint
     */
    private Paint mInnerCirclePaint;

    /**
     * 绘制外部圆环的Paint
     */
    private Paint mOutterRingPaint;

    /**
     * 外环宽度
     */
    private int mOuttterRingWidth = 50;
    /**
     * 内圆半径
     */
    private int mInnerRadius = 50;


    /**
     * 存储计算所得的外环半径
     */
    private int[] mRadius = new int[4];

    private int width;
    private int height;


    //属性动画;
    private ValueAnimator mValueAnimator;
    //外圆环个数;
    private int mOutterRingCount = 4;


    public WaterWaveView(Context context) {
        this(context, null);
    }

    public WaterWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaterWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        startAnimation();
    }

    private void init() {

        mInnerCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInnerCirclePaint.setColor(Color.BLUE);
        /** 内部画笔为实心 **/
        mInnerCirclePaint.setStyle(Paint.Style.FILL);


        mOutterRingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mOutterRingPaint.setColor(Color.BLUE);
        /** 外部画笔为空心 **/
        mOutterRingPaint.setStyle(Paint.Style.STROKE);
        mOutterRingPaint.setStrokeWidth(mOuttterRingWidth);


        //设置外环的宽度;
        for (int i = 0; i < mOutterRingCount; i++) {
            mRadius[i] = mInnerRadius + (i * 2 + 1) * mOuttterRingWidth / 2;
            Log.d("print", "init: ---mRadius[i]---" + mRadius[i]);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (w > 0 && h > 0) {
            this.width = w;
            this.height = h;
        }
    }

    private void startAnimation() {

        //动态改变圆环个数达到水波的效果;
        mValueAnimator = ValueAnimator.ofInt(0, 5);
        mValueAnimator.setRepeatMode(ValueAnimator.RESTART);
        mValueAnimator.setRepeatCount(-1);
        mValueAnimator.setDuration(3000);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOutterRingCount = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        mValueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width / 2, height / 2, mInnerRadius, mInnerCirclePaint);

        for (int i = 0; i < mOutterRingCount; i++) {
            mOutterRingPaint.setAlpha(255 - (int) (255 * ((float) (i + 1) / 5)));
            canvas.drawCircle(width / 2, height / 2, mRadius[i], mOutterRingPaint);
        }
    }
}
