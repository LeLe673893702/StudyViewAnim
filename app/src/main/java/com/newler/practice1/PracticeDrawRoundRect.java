package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/5/24
 */
public class PracticeDrawRoundRect extends View {
    public PracticeDrawRoundRect(Context context) {
        super(context);
    }

    public PracticeDrawRoundRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawRoundRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        canvas.drawRoundRect(10,10,100,100,35,35,paint);
        Paint paint1 = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(false);

        // 矩形的圆角是椭圆的一角组成的，rx椭圆的横半轴，ry椭圆的竖半轴
        canvas.drawRoundRect(150,10,250,100,35,35,paint1);
    }
}
