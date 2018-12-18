package com.newler.practice5;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.newler.studyview.R;
import com.newler.studyview.ScreenUtil;

/**
 * @author newler
 * @what
 * @date 2018/12/15
 */
public class PracticeCircleSegmentView extends View {
    private Paint mPaint;
    private Path mPath, dstPath;
    private PathMeasure mPathMeasure;
    private float rate;
    private Bitmap mBitmap;
    Matrix matrix = new Matrix();
    private float[] pos = new float[2];
    private float[] tans = new float[2];

    public PracticeCircleSegmentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);

        mPath = new Path();
        mPath.addCircle(200,200, 100, Path.Direction.CW);
        dstPath = new Path();

        mPathMeasure = new PathMeasure(mPath, true);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(3000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rate = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        dstPath.reset();
        matrix.reset();
        mPathMeasure.getSegment(0, rate, dstPath, true);
        // pos代表是真正的坐标值，tans代表：y/x = 根号3/2 tans[0] = 1/2 tan[1] = 1/根号3
        mPathMeasure.getPosTan(rate, pos, tans);

        // 获取数组,获取贴边和获取转动角度
        mPathMeasure.getMatrix(rate, matrix, PathMeasure.POSITION_MATRIX_FLAG|PathMeasure.TANGENT_MATRIX_FLAG);
        canvas.drawPath(dstPath, mPaint);
        Log.e("pos", pos[0] + "----" + pos[1]);

        matrix.postTranslate(pos[0] - mBitmap.getWidth()/2, pos[1] - mBitmap.getHeight()/2);
        canvas.drawBitmap(mBitmap, matrix, mPaint);
    }
}
