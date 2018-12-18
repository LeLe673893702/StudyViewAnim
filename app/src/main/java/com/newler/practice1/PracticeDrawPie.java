package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author 刺雒
 * @what
 * @date 2018/6/2
 */
public class PracticeDrawPie extends View {
    public PracticeDrawPie(Context context) {
        super(context);
    }

    public PracticeDrawPie(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDrawPie(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        RectF rect = new RectF(0, 0, 400, 400);

        paint.setColor(Color.RED);
        canvas.drawArc(rect,0, 60, true, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        Path path = new Path();
        float x1 = getCirclePointX(200,200,30);
        float y1 = getCirclePointY(200, 200 ,30);
        Log.e("x:",x1+"");
        Log.e("y:",y1+"");
        path.moveTo(x1, y1);
        path.lineTo(x1+20, y1);
        path.rLineTo(20,-10);
        canvas.drawPath(path, paint);

        paint.setTextSize(40);
        canvas.drawText("饼图", x1+50,y1-10, paint);
//        paint.setColorFilter();
        new LightingColorFilter(0x11,0x22);
    }

    private float getCirclePointX(int x, int r, int angle) {
        return (float) (x + r*Math.cos(angle*Math.PI / 180));
    }

    private float getCirclePointY(int y, int r, int angle) {
        return (float) (y + r*Math.sin(angle*Math.PI / 180));
    }

}
