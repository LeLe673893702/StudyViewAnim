package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/6/2
 */
public class PracticeDrawHistogram extends View {
    public PracticeDrawHistogram(Context context) {
        super(context);
    }

    public PracticeDrawHistogram(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawHistogram(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        Path path = new Path();
        // 画x轴
        path.moveTo(100,100);
        path.lineTo(100, 600);
        // 画y轴
        path.rLineTo(500, 0);
        canvas.drawPath(path, paint);

        // 画直方图
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(200,200,300,600, paint);

        // 绘制直方图上文字
        paint.setColor(Color.BLACK);
        paint.setTextSize(26);
        canvas.drawText("直方图", 200,170, paint);
    }
}
