package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/5/24
 */
public class PracticeDrawPoint extends View {
    public PracticeDrawPoint(Context context) {
        super(context);
    }

    public PracticeDrawPoint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawPoint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        // 圆点
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.BLUE);
        canvas.drawPoint(100,100, paint);

        // 方点
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(150,300, paint);

        float[] points = {0,0,100,100,200,200,300,300,400,400,500,500};

        canvas.drawPoints(points, paint);
        // 去掉过滤掉前面不需要绘制的点数offset>>1, 需要绘制的点数数量为count>>1
        canvas.drawPoints(points, 2, 8, paint);

    }
}
