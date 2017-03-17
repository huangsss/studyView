package com.study.huangasys.pieChart;

/**
 * Created by "huangsays" "健" on 2017/3/16.17:08"huangays@gmail.com"
 */

public class PieData {
    //用户关心数据
    private String name;//名字
    private float value;//数值
    private float percentage;//百分比

    //非用户关心数据;
    private int color = 0;//颜色
    private float angle = 0; //角度

    public int getColor() {
        return color;
    }

    public float getAngle() {
        return angle;
    }

    public PieData(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
