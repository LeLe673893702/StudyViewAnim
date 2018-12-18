package com.newler.practice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.newler.studyview.R;

/**
 * @author 刺雒
 * @what 通过矩阵 设置 rgba
 * @date 2018/6/4
 */
public class PracticeColorMatrixColorFilter extends View {
    public PracticeColorMatrixColorFilter(Context context) {
        super(context);
    }

    public PracticeColorMatrixColorFilter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeColorMatrixColorFilter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.demo), 0 ,0 ,paint);
    }
}
