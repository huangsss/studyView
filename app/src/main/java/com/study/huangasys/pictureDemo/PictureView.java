package com.study.huangasys.pictureDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangasys on 2018/6/1.14:19
 *
 * @Describe:
 */

public class PictureView extends View {

    private Picture mPicture;

    public PictureView(Context context) {
        this(context,null);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPicture  = new Picture();
        recoding();//录制的内容不会直接显示;


    }

    private void recoding() {
        Canvas canvas = mPicture.beginRecording(500,500);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.translate(250,250);
        canvas.drawCircle(0,0,100,mPaint);
        mPicture.endRecording();

        canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth(),200));
    }

}
