package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/5/24
 */
public class PracticeDrawColor extends View {
    public PracticeDrawColor(Context context) {
        super(context);
    }

    public PracticeDrawColor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawColor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
    }
}
