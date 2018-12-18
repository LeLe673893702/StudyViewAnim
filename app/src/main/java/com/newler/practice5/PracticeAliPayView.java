package com.newler.practice5;

import android.animation.Animator;
import android.animation.AnimatorSet;
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
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.newler.studyview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author newler
 * @what
 * @date 2018/12/15
 */
public class PracticeAliPayView extends View {
    private Paint mPaint;
    private Path mPath, dstPath;
    private PathMeasure mPathMeasure;
    private float rate;
    private Bitmap mBitmap;
    Matrix matrix = new Matrix();
    private float[] pos = new float[2];
    private float[] tans = new float[2];

    public PracticeAliPayView(Context context, @Nullable AttributeSet attrs) {
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
        mPath.moveTo(150, 180);
        mPath.lineTo(200, 200);
        mPath.lineTo(150,150);


        dstPath = new Path();
        mPathMeasure = new PathMeasure(mPath, false);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow);
        AnimatorSet animatorSet = new AnimatorSet();
        List<Animator> list = new ArrayList<>();
        for (int i = 0; i < 1 ; i++) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 2);
//            valueAnimator.setDuration(3000);
//            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    rate = (float) animation.getAnimatedValue();
                        invalidate();

                }
            });
            list.add(valueAnimator);
        }
        animatorSet.playSequentially(list);
        animatorSet.setDuration(4000);
        animatorSet.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dstPath.reset();
        matrix.reset();
        if (rate == 1) {
            mPathMeasure.getSegment(0, mPathMeasure.getLength(), dstPath, true);
            mPathMeasure.nextContour();
        } else
        if(rate < 1) {
            mPathMeasure.getSegment(0, rate * mPathMeasure.getLength(), dstPath, true);
        } else {
            mPathMeasure.getSegment(0, (rate-1) * mPathMeasure.getLength(), dstPath, true);
            Log.e("pos", rate+"----"+(rate-1) *mPathMeasure.getLength());

        }
//        mPathMeasure.getPosTan(rate, pos, tans);

        // 获取数组,获取贴边和获取转动角度
//        mPathMeasure.getMatrix(rate, matrix, PathMeasure.POSITION_MATRIX_FLAG|PathMeasure.TANGENT_MATRIX_FLAG);
        canvas.drawPath(dstPath, mPaint);

//        matrix.postTranslate(pos[0] - mBitmap.getWidth()/2, pos[1] - mBitmap.getHeight()/2);
//        canvas.drawBitmap(mBitmap, matrix, mPaint);
    }
}
