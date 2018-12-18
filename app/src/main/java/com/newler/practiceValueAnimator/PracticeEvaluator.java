package com.newler.practiceValueAnimator;

import android.animation.TypeEvaluator;

/**
 * @author newler
 * @what
 * @date 2018/12/5
 */
public class PracticeEvaluator implements TypeEvaluator<Integer> {
    /**
     * @param fraction 表示当前动画的进度值 0-1
     * @param startValue 表示起始值
     * @param endValue 表示终点值
     *
     */
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int)(endValue - (endValue - startValue) * fraction);
    }
}
