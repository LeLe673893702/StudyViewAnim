package com.newler.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what 扫面渐变，绕着指定点做从0度到360度的颜色渐变
 * @date 2018/6/4
 */
public class PracticeSweepGradientView extends View {
    public PracticeSweepGradientView(Context context) {
        super(context);
    }

    public PracticeSweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeSweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        SweepGradient sweepGradient = new SweepGradient(200,200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"));
        paint.setShader(sweepGradient);
        canvas.drawCircle(200, 200 ,200, paint);
    }
}
