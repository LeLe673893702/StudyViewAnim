package com.newler.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.newler.studyview.R;

/**
 * @author 刺雒
 * @what
 * @date 2018/6/4
 */
public class PracticeLightingColorFilter extends View {
    private Paint paint;

    public PracticeLightingColorFilter(Context context) {
        super(context);
    }

    public PracticeLightingColorFilter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeLightingColorFilter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        LightingColorFilter removeRedFilter = new LightingColorFilter(0x00ffff, 0x00);
        LightingColorFilter addGreenFilter = new LightingColorFilter(0xffffff, 0x00fd00);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.demo);

        paint.setColorFilter(removeRedFilter);
        canvas.drawBitmap(bitmap, 0,0 ,paint);

        paint.setColorFilter(addGreenFilter);
        canvas.drawBitmap(bitmap, bitmap.getWidth()+100, 0, paint);

    }
}
