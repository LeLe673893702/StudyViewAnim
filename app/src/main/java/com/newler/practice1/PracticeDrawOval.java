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
public class PracticeDrawOval extends View {
    public PracticeDrawOval(Context context) {
        super(context);
    }

    public PracticeDrawOval(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawOval(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        canvas.drawOval(500, 500, 600, 900, paint);
    }
}
