package com.newler.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what 辐射渐变, 从圆心开始渐变
 * @date 2018/6/4
 */
public class PracticeRadialGradientView extends View {
    public PracticeRadialGradientView(Context context) {
        super(context);
    }

    public PracticeRadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeRadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        paint.setStyle(Paint.Style.FILL);

        RadialGradient radialGradient = new RadialGradient(300,300,200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        paint.setShader(radialGradient);

        canvas.drawCircle(200, 200, 200, paint);
    }
}
