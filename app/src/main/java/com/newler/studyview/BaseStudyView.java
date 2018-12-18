package com.newler.studyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/5/23
 */
public class BaseStudyView extends View {
    public BaseStudyView(Context context) {
        super(context);
    }

    public BaseStudyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseStudyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        path.addRect(100,100,100,100, Path.Direction.CW);

    }
}
