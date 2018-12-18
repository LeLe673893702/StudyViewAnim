package com.newler.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author newler
 * @what
 * @date 2018/11/18
 */
public class RectPointView extends View {
    private int clickX = -1, clickY = -1;
    private Paint mPaint;
    private Rect mRect;
    public RectPointView(Context context) {
        super(context);
    }

    public RectPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setStrokeWidth(20f);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);

        mRect = new Rect(100,100,650,450);
    }

    public RectPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mRect.contains(clickX, clickY)) {
            mPaint.setColor(Color.RED);
        } else {
            mPaint.setColor(Color.GREEN);
        }
        canvas.drawRect(mRect, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        clickX = (int) event.getX();
        clickY = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            invalidate();
            return true;
        }else if (event.getAction() == MotionEvent.ACTION_UP) {
            clickX = -1;
            clickY = -1;
        }
        // 抬起手来恢复原状
        invalidate();
        return super.onTouchEvent(event);
    }
}
