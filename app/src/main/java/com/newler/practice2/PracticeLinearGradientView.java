package com.newler.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what 径向渐变, 根据一条直线渐变
 * @date 2018/6/4
 */
public class PracticeLinearGradientView extends View {
    public PracticeLinearGradientView(Context context) {
        super(context);
    }

    public PracticeLinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeLinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        LinearGradient linearGradient = new LinearGradient(100, 100, 500, 500,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(100,100, 200, paint);

    }
}
