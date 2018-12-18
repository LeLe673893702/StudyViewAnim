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
public class PracticeDrawArc extends View {
    public PracticeDrawArc(Context context) {
        super(context);
    }

    public PracticeDrawArc(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawArc(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 弧形
        canvas.drawArc(100, 200, 200, 300, 60, 120 , false, paint);
        // 扇形
        canvas.drawArc(100, 200 , 200 , 300, 60, 180, true , paint);
    }
}
