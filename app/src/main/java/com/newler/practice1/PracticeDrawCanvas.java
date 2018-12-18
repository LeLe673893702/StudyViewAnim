package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author newler
 * @what
 * @date 2018/11/26
 */
public class PracticeDrawCanvas extends View {
    private Paint paint;
    Rect rect = new Rect(0,0,100,100);

    public PracticeDrawCanvas(Context context) {
        super(context);
        init();
    }

    public PracticeDrawCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        translate(canvas);
//        rotate(canvas);
//        clip(canvas);
        saveAndReStore(canvas);
    }

    /**
     * 每次调用drawXXX系列函数来绘图，都会产生一个全新的Canvas透明图层
     * 如果在调用drawXXX系列函数前，调用平移、旋转等函数对Canvas进行操作，绘制的图像都是在操作后的canvas上显示
     * Canvas图层与屏幕合成时，超出屏幕范围的图像是不会显示的
     */
    private void translate(Canvas canvas) {
        canvas.drawRect(rect, paint);

        canvas.translate(200, 200);
        paint.setColor(Color.RED);
        canvas.drawRect(rect, paint);
    }

    /**
     * degrees：画布旋转的角度，+顺时针旋转，-逆时针旋转
     * px，py：画布旋转的中心点
     */
    private void rotate(Canvas canvas) {
        canvas.drawRect(rect, paint);

        canvas.rotate(50);
        paint.setColor(Color.RED);
        canvas.drawRect(rect, paint);
    }

    /**
     * 缩放
     * sx，sy分别是水平和竖直方向伸缩比例，小数为缩小，整数为放大，1是不变
     * px，py分别是缩放的中心点
     */
    private void scale(Canvas canvas) {
        canvas.drawRect(rect, paint);

        canvas.scale(50, 50);
        paint.setColor(Color.RED);
        canvas.drawRect(rect, paint);
    }

    /**
     * 裁剪画布,使用clip系列函数通过与rect、path、region取交、并、差集合运算获取最新的画布形状
     */
    private void clip(Canvas canvas) {
        canvas.drawColor(Color.RED);
        canvas.clipRect(new Rect(100,100,200,200));
        canvas.drawColor(Color.GREEN);
    }

    /**
     * save保存当前画布的状态，将其放入特定的栈中
     * restore把栈中的画布状态取出来，按照这个状态恢复当前画布，并在这个画布上操作
     */
    private void saveAndReStore(Canvas canvas) {
        canvas.drawColor(Color.RED);
        // 压栈
        canvas.save();

        canvas.clipRect(new Rect(0,0,400,400));
        canvas.drawColor(Color.GREEN);
        // 压栈
        canvas.save();

        canvas.clipRect(new Rect(0,0,300,300));
        canvas.drawColor(Color.GRAY);
        // 压栈
        canvas.save();

        canvas.clipRect(new Rect(0,0,200,200));
        canvas.drawColor(Color.BLACK);
        // 压栈
        canvas.save();

        canvas.clipRect(new Rect(0,0,100,100));
        canvas.drawColor(Color.BLUE);
        // 压栈
        canvas.save();

        // 出栈，取出顶层栈的，400,400
//        canvas.restore();

        // 出栈，取出指定位置,起点不是从0开始而是从1开始的
        canvas.restoreToCount(2);
        canvas.drawColor(Color.YELLOW);
    }
}
