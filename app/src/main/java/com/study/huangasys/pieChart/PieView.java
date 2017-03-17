package com.study.huangasys.pieChart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by "huangsays" "健" on 2017/3/16.17:06"huangays@gmail.com"
 * 饼状图;
 */

public class PieView extends View {

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private float mStartAngle = 0;//初始绘制角度;
    private ArrayList<PieData> mData;//数据;
    private int mWidth, mHight;//宽高;
    private Paint mPaint;//画笔;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setStyle(Paint.Style.FILL);//填充;
        mPaint.setAntiAlias(true);//抗锯齿;

    }

    /**
     * 确定View大小(记录当前View的宽高)
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHight = h;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData)
            return;
        float currentStarAngle = mStartAngle;//当前起始角度;
        canvas.translate(mWidth / 2, mHight / 2);//将画布坐标原点移动到中心位置;
        float r = (float) ((Math.min(mWidth, mHight)) / 2 * 0.8);//饼状图的半径;
        RectF rectF = new RectF(-r, -r, r, r);//绘制的区域;

        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());//数据的颜色;
            canvas.drawArc(rectF, currentStarAngle, pie.getAngle(), true, mPaint);//绘制弧度;
            currentStarAngle += pie.getAngle();//每绘制完一次 初始角度则增大一次;
        }
    }

    //设置初始角度;
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();//在更改了数据需要重绘界面时要调用invalidate()这个函数重新绘制。
    }

    //设置数据;
    public void setmData(ArrayList<PieData> mData) {
        this.mData = mData;
    }

    /**
     * 初始化数据;
     *这里的数据有 数值的数据即可;
     * @param mData
     */
    private void initData(ArrayList<PieData> mData) {
        if (null == mData || mData.size() == 0)
            return;
        float sumValue=0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            sumValue += pie.getValue();//计算数值的和;

            int j = i % mColors.length;
            pie.setColor(j);//设置颜色

        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            float percentage = pie.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            pie.setPercentage(percentage);                  // 记录百分比
            pie.setAngle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.i("angle", "" + pie.getAngle());
        }

    }

}
