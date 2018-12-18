package com.newler.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * @author newler
 * @what
 * @date 2018/12/15
 */
public class PracticePathMeasure extends View {
    private PathMeasure mPathMeasure1, mPathMeasure2;
    private Path mPath, dstPath;
    private Paint mPaint;

    public PracticePathMeasure(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPathMeasure1 = new PathMeasure(mPath, false);
        mPathMeasure2 = new PathMeasure(mPath, true);

        mPath = new Path();
        dstPath = new Path();

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        getLength();
        getSegment();
        canvas.drawPath(dstPath, mPaint);
    }

    /**
     * forceClosed如果设置成true计算的就是就是闭合的Path产股
     * measure1：长度为200，measure2：长度为150
     */
    private void getLength() {
        mPath.moveTo(50,50);
        mPath.lineTo(50, 100);
        mPath.lineTo(100, 100);
        mPath.lineTo(100, 50);
        mPathMeasure1.setPath(mPath, true);
        mPathMeasure2.setPath(mPath, false);
        Log.e("pathLength", "PathLength:"+mPathMeasure1.getLength()+"-------"+mPathMeasure2.getLength());
    }

    /**
     * 这个是截取长度
     * startWithMoveTo 如果设置成true截取的路径起始点变成了（700，700）
     * 设置成false则会调用moveTo移动到截取路径的起始点处
     */
    private void getSegment() {
        mPath.addRect(100, 100, 300, 300, Path.Direction.CW);
        dstPath.lineTo(700, 700);
        // 一定要是设置，即使构造函数中已经传入了Path也要设置
        mPathMeasure1.setPath(mPath, false);
        // 截取的Path是添加到dstPath中的
        mPathMeasure1.getSegment(100, 400, dstPath,false);
    }
}
