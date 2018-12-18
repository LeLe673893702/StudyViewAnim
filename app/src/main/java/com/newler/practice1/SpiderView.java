package com.newler.practice1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author newler
 * @what
 * @date 2018/11/20
 */
public class SpiderView extends View {
    private Paint radarPaint, valuePaint;

    private float radius;
    private int centerX, centerY;

    public SpiderView(Context context) {
        super(context);
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        radarPaint = new Paint();
        radarPaint.setStyle(Paint.Style.STROKE);
        radarPaint.setAntiAlias(true);
        radarPaint.setColor(Color.GRAY);

        valuePaint = new Paint();
        valuePaint.setAntiAlias(true);
        valuePaint.setStyle(Paint.Style.FILL);
        valuePaint.setColor(Color.BLACK);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void drawRadar() {
        Path path =new Path();
        int count = 5;
        path.moveTo(centerX, centerY);
        for (int i = 0; i < count; i++) {
            double x = centerX + centerX * Math.cos(Math.toRadians(30));
        }
    }

}
