package com.study.huangasys.radarView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.study.huangasys.studyview.R;

/**
 * Created by huangasys on 2018/5/30.18:02
 *
 * @Describe:
 */

public class RadarView extends View {


    private int count = 5; //几边形
    private int layerCount = 4; //几层的外边数
    private float angle; //每条边对应的圆心角

    private int centerX; //圆心x
    private int centerY; //圆心y
    private float radius; //半径

    private Paint polygonPaint; //边框paint
    private Paint linePaint; //连线paint
    private Paint txtPaint; //文字paint
    private Paint circlePaint; //圆点paint
    private Paint regionColorPaint; //覆盖区域paint

    private Double[] percents = {0.91, 0.35, 0.12, 0.8, 0.5}; //覆盖区域百分比
    private String[] titles = {"dota", "斗地主", "大吉大利，晚上吃鸡", "炉石传说", "跳一跳"};//文字


    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //计算圆心角;
        angle = (float) (Math.PI * 2 / count);
        //边框paint;
        polygonPaint = new Paint();
        polygonPaint.setColor(ContextCompat.getColor(context, R.color.common_tv66));
        polygonPaint.setAntiAlias(true);
        polygonPaint.setStyle(Paint.Style.STROKE);
        polygonPaint.setStrokeWidth(4f);
        //线paint;
        linePaint = new Paint();
        linePaint.setColor(ContextCompat.getColor(context, R.color.common_tv77));
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(4f);
        //文字paint;
        txtPaint = new Paint();
        txtPaint.setColor(ContextCompat.getColor(context, R.color.common_tv80));
        txtPaint.setAntiAlias(true);
        txtPaint.setStyle(Paint.Style.STROKE);
        txtPaint.setTextSize(40);
        //circlePaint;
        circlePaint = new Paint();
        circlePaint.setColor(ContextCompat.getColor(context, R.color.common_tv55));
        circlePaint.setAntiAlias(true);
        //覆盖区域paint;
        regionColorPaint = new Paint();
        regionColorPaint.setColor(ContextCompat.getColor(context, R.color.common_blue4b));
        regionColorPaint.setStyle(Paint.Style.FILL);
        regionColorPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);//画边
        drawLines(canvas);//画线
        drawText(canvas);//描绘文字
        drawRegion(canvas);//覆盖区域
    }

    //需要正五边形得有一个圆，圆内接正五边形，在onSizeChanged方法里获取圆心，确定半径
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = Math.min(w, h) / 2 * 0.7f;//半径
        //圆心点;
        centerX = w / 2;
        centerY = h / 2;
    }
    //画边
    private void drawPolygon(Canvas canvas) {
        Path path = new Path();
        float r =  radius / layerCount;

        for (int i = 1; i <= layerCount; i++) {
            float curR = i*r;//当前层的半径;
            //几边型;
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    //移动至xx点;
                    path.moveTo(centerX, centerY - curR);
                }else{
                    //顺时针记录其余顶角坐标的点;
                    float x = (float) (centerX + Math.sin(angle * j) * curR);
                    float y = (float) (centerY - Math.cos(angle * j) * curR);
                    path.lineTo(x,y);
                }
            }
            path.close();
            canvas.drawPath(path,polygonPaint);
        }



    }

    //覆盖区域
    private void drawRegion(Canvas canvas) {

    }

    //描绘文字
    private void drawText(Canvas canvas) {

    }

    //画线
    private void drawLines(Canvas canvas) {

    }



}
