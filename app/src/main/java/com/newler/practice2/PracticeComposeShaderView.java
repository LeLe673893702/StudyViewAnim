package com.newler.practice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.newler.studyview.R;

/**
 * @author 刺雒
 * @what 两种着色器组合使用
 * @date 2018/6/4
 */
public class PracticeComposeShaderView extends View {
    private Paint paint;
    public PracticeComposeShaderView(Context context) {
        super(context);
    }

    public PracticeComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        BitmapShader bitmapShader = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.demo),
                Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);
        SweepGradient sweepGradient = new SweepGradient(200, 200, Color.parseColor("#000000"),
                Color.parseColor("#FFFFFF"));
        ComposeShader composeShader = new ComposeShader(bitmapShader, sweepGradient, PorterDuff.Mode.DST_OUT);
        paint.setShader(composeShader);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200, 200, 200, paint);
    }
}
