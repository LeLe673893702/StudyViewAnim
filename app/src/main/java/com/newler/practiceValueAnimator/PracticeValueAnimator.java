package com.newler.practiceValueAnimator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author newler
 * @what
 * @date 2018/12/4
 */
public class PracticeValueAnimator extends View {
    private  ValueAnimator newValueAnimator = ValueAnimator.ofInt(0, 100);
    /**
     * 深拷贝
     */
    private ValueAnimator cloneValueAnimator = newValueAnimator.clone();
    private boolean start = true;
    public PracticeValueAnimator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        setBackgroundColor(Color.BLACK);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    // 如果页面跳转必须要取消动画，否则会内存泄漏
                    newValueAnimator.pause();
                } else {
                    newValueAnimator.resume();
                }
                start = !start;
            }
        });
    }

    private void init() {
        newValueAnimator.setDuration(5000);
        newValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        newValueAnimator.setRepeatCount(10);
//        newValueAnimator.setEvaluator(new PracticeEvaluator());

        newValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                startAnim((Integer) animation.getAnimatedValue());
            }
        });

        newValueAnimator.start();
    }

    private void initClone() {
        cloneValueAnimator.start();
    }

    private void startAnim(int carValue) {
        Log.e("width", getWidth()+"----"+getHeight());
        layout(carValue,carValue,carValue+getWidth(),carValue+getHeight());
    }

    public void onDestroy() {
        newValueAnimator.removeAllListeners();
    }
}
