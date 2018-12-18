package com.newler.practice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.newler.studyview.R;

/**
 * @author 刺雒
 * @what bitmap填充器
 * @date 2018/6/4
 */
public class PracticeBitmapShaderView extends View {
    public PracticeBitmapShaderView(Context context) {
        super(context);
    }

    public PracticeBitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeBitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        BitmapShader bitmapShader = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.demo)
        , Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);

        paint.setShader(bitmapShader);

        canvas.drawRect(0,0, 500, 600, paint);
    }
}
