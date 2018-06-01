package com.study.huangasys.textDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangasys on 2018/6/1.14:44
 *
 * @Describe:
 */

public class TextView extends View {

    private Paint mPaint;

    public TextView(Context context) {
        this(context, null);
    }

    public TextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(50);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String str = "ABCDE";
        // 1.参数分别为 (文本 基线x 基线y 画笔)
        //canvas.drawText(str, 200, 500, mPaint);

        //2.使用start和end指定的区间是前闭后开的，即包含start指定的下标，而不包含end指定的下标，故[1,3)最后获取到的下标只有 下标1 和 下标2 的字符，就是”BC”.
//        canvas.drawText(str, 1, 3, 200, 500, mPaint)


        canvas.drawPosText(str,new float[]{
                100,100,    // 第一个字符位置
                200,200,    // 第二个字符位置
                300,300,    // ...
                400,400,
                500,500
        },mPaint);
    }

}
