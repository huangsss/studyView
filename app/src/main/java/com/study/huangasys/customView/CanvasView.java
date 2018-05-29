package com.study.huangasys.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by huangasys on 2017/12/6.19:02
 */

public class CanvasView extends View {

    private Paint mPaint;

    private Canvas mCanvas = new Canvas();

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
        mPaint.setColor(Color.BLUE);
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
        Log.d("print", "onDraw: "+mWidth+"sss"+mHeight);
        Rect rect = new Rect(100, 100, 800, 400);
        canvas.drawRect(rect, mPaint);

        super.onDraw(canvas);

    }
}
