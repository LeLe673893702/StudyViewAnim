package com.newler.practiceValueAnimator;

import android.animation.TimeInterpolator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;

/**
 * @author newler
 * @what
 * @date 2018/12/5
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
public class PracticeCustomInterpolator implements Interpolator {
    /**
     * @param input 表示播放进度
     * 控件动画变化值= （终点值-起点值） * input
     */
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
